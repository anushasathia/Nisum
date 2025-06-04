// script.js

// --- DOM Elements (using const for references) ---
const todoInput = document.getElementById('todo-input');
const addTodoBtn = document.getElementById('add-todo-btn');
const todoListUl = document.getElementById('todo-list');
const clearCompletedBtn = document.getElementById('clear-completed-btn');
const filterButtons = document.querySelector('.filters');

// --- Global State (using let for mutable Map) ---
let todosMap = new Map(); // Map to store todos by ID for efficient lookup
let currentFilter = 'all';

// --- Symbols for unique IDs and localStorage key ---
const TODO_ID_SYMBOL = Symbol('todoUniqueId'); // Symbols: for internal object identification
const STORAGE_KEY = Symbol('todoListStorageKey'); // Symbols: for unique localStorage key

// --- Class for TodoItem (using Class, Public Properties, Getters/Setters, Enhanced Object Literals) ---
class TodoItem { // Classes
    // Changed from private fields (#text) to public properties (this.text)
    // This resolves the "Unexpected identifier '#text'" error.
    text;
    isCompleted; // Renamed for consistency with getters/setters
    id;
    createdAt;

    // Static generator for unique IDs (Generators, Iterators)
    static *idGenerator() { // Generators
        let id = Date.now(); // Start with current timestamp for unique IDs
        while (true) {
            yield id++; // Yields a unique ID in each iteration
        }
    }
    static generatorInstance = TodoItem.idGenerator(); // Static property for the generator

    constructor(text, completed = false, id = TodoItem.generatorInstance.next().value) { // Default Parameters
        this.text = text;
        this.isCompleted = completed;
        this.id = id;
        this.createdAt = new Date();
        this[TODO_ID_SYMBOL] = id; // Attach symbol as a non-enumerable, unique ID
    }

    get completed() { // Getter for completed status
        return this.isCompleted;
    }

    set completed(value) { // Setter for completed status
        if (typeof value === 'boolean') {
            this.isCompleted = value;
        } else {
            console.warn("Completed status must be a boolean.");
        }
    }

    toggleCompleted() { // Method shorthand in class
        this.isCompleted = !this.isCompleted;
    }

    // Method to return a plain object for serialization (using destructuring, enhanced object literals)
    toPlainObject() {
        // Destructuring assignment to extract public property values
        const { text, isCompleted: completed, id, createdAt } = this; // Use `isCompleted` and alias to `completed`
        // Enhanced Object Literals for concise object creation
        return { text, completed, id, createdAt: createdAt.toISOString() };
    }
}

// --- WeakMap and WeakSet for conceptual metadata/tracking ---
const elementMetadata = new WeakMap(); // WeakMap

const setElementMetadata = (element, key, value) => {
    let data = elementMetadata.get(element) || {};
    data[key] = value;
    elementMetadata.set(element, data);
};

const processedElements = new WeakSet(); // WeakSet

const markElementAsProcessed = (element) => {
    processedElements.add(element);
};

// --- Async Simulation with Promises (for loading/saving) ---
const saveTodos = () => {
    return new Promise(resolve => { // Promises
        setTimeout(() => { // Simulate async save operation
            const todosArray = Array.from(todosMap.values()).map(todo => todo.toPlainObject()); // Array.from() to convert Map values, map to plain objects
            localStorage.setItem(STORAGE_KEY.description, JSON.stringify(todosArray));
            console.log("Todos saved!");
            resolve();
        }, 100);
    });
};

const loadTodos = () => {
    return new Promise((resolve, reject) => { // Promises
        setTimeout(() => { // Simulate async load operation
            try {
                const storedTodos = localStorage.getItem(STORAGE_KEY.description);
                if (storedTodos) {
                    const parsedTodos = JSON.parse(storedTodos);
                    todosMap = new Map(
                        Array.from(parsedTodos, data => { // Array.from() for mapping
                            const { text, completed, id } = data; // Destructuring Assignment
                            return [id, new TodoItem(text, completed, id)];
                        })
                    );
                    console.log("Todos loaded!");
                } else {
                    console.log("No todos found in storage.");
                }
                resolve();
            } catch (error) {
                console.error("Failed to load todos:", error);
                reject(error);
            }
        }, 100);
    });
};

// --- Rendering Logic (using Arrow Functions, Template Literals, for...of, Spread) ---
const renderTodos = () => { // Arrow Function
    todoListUl.innerHTML = ''; // Clear previous items
    let displayedTodos = Array.from(todosMap.values()); // Array.from() to get a mutable array from Map values

    if (currentFilter === 'active') {
        displayedTodos = displayedTodos.filter(todo => !todo.completed); // Arrow function for filter
    } else if (currentFilter === 'completed') {
        displayedTodos = displayedTodos.filter(todo => todo.completed); // Arrow function for filter
    }

    if (displayedTodos.length === 0) {
        // Template Literals for content
        todoListUl.innerHTML = `<li class="todo-item"><span style="color: #666;">No todos to display for this filter.</span></li>`;
        return;
    }

    // Using for...of loop for iteration
    for (const todo of displayedTodos) { // Iterators and for...of Loop
        const li = document.createElement('li');
        li.classList.add('todo-item');
        if (todo.completed) {
            li.classList.add('completed');
        }
        li.dataset.id = todo.id; // Store ID on the DOM element

        // Template Literals for complex HTML structure
        li.innerHTML = `
            <input type="checkbox" ${todo.completed ? 'checked' : ''}>
            <span>${todo.text}</span>
            <button class="delete-btn">Delete</button>
        `;

        // Use WeakMap to store a reference to the TodoItem instance on the DOM element
        setElementMetadata(li, 'todoInstance', todo);

        todoListUl.appendChild(li);
    }
};

// --- Event Listeners ---

// Add Todo Button
addTodoBtn.addEventListener('click', () => { // Arrow Function
    const text = todoInput.value.trim();
    if (text) {
        const newTodo = new TodoItem(text); // Class instance
        todosMap.set(newTodo.id, newTodo); // Add to Map
        saveTodos().then(renderTodos); // Promises for async rendering
        todoInput.value = ''; // Clear input
        console.log("Added todo:", newTodo);
    }
});

// Listener for clicks on the todo list itself (delegation for checkboxes and delete buttons)
todoListUl.addEventListener('click', (event) => { // Arrow Function
    const target = event.target;
    const listItem = target.closest('.todo-item'); // Find the closest todo item li

    if (!listItem) return; // Not a todo item click

    const todoId = parseInt(listItem.dataset.id);
    const todo = todosMap.get(todoId);

    if (!todo) return; // Todo not found in map

    if (target.type === 'checkbox') {
        // Object.is() for strict equality check
        const isChecked = Object.is(target.checked, true);
        todo.completed = isChecked; // Use setter
        saveTodos().then(renderTodos);
        // Mark the DOM element as processed by the user for this action (WeakSet use)
        markElementAsProcessed(listItem);
    } else if (target.classList.contains('delete-btn')) {
        todosMap.delete(todoId); // Remove from Map
        saveTodos().then(renderTodos);
    }
});

// Clear Completed Button
clearCompletedBtn.addEventListener('click', () => { // Arrow Function
    // Filter out completed todos and update the map using Array.from and Map constructor
    todosMap = new Map(
        Array.from(todosMap.entries()).filter(([id, todo]) => !todo.completed)
    );
    saveTodos().then(renderTodos);
});

// Filter Buttons (All, Active, Completed)
filterButtons.addEventListener('click', (event) => { // Arrow Function
    const target = event.target;
    if (target.tagName === 'BUTTON') {
        // Get all filter buttons using Array.from()
        Array.from(filterButtons.children).forEach(btn => btn.classList.remove('active'));
        target.classList.add('active');
        // Destructuring assignment to extract part of the ID string
        const [_, filterType] = target.id.split('-'); // Destructuring Assignment
        currentFilter = filterType;
        renderTodos();
    }
});

// --- Initial Load and Feature Demonstrations ---
document.addEventListener('DOMContentLoaded', () => { // Arrow Function
    loadTodos().then(renderTodos); // Load existing todos and then render them

    // --- Demonstrations of other ES6 features ---

    // Array.of() for creating an array from arguments
    const statusMessages = Array.of("App initialized", "Ready to add todos!");
    console.log("Array.of example:", statusMessages);

    // Object.assign() for merging objects
    const defaultTodoData = { text: "Learn JS", completed: false };
    const urgentTodoData = Object.assign({}, defaultTodoData, { priority: "high", dueDate: "today" }); // Object.assign()
    console.log("Object.assign example:", urgentTodoData);

    // Spread Operator for merging objects (alternative to Object.assign)
    const anotherUrgentTodoData = { ...defaultTodoData, priority: "very high" }; // Spread Operator
    console.log("Another Urgent Todo (Spread):", anotherUrgentTodoData);

    // Rest Operator in a function
    function logManyArgs(prefix, ...args) { // Rest Operator
        console.log(`${prefix}:`, ...args); // Spread Operator (for logging arguments)
    }
    logManyArgs("Debugging Info", "Application started", 123, { status: "OK" });

    // Set for unique values
    const tags = new Set(['coding', 'work', 'coding', 'personal']);
    console.log("Set example (unique tags):", Array.from(tags)); // Array.from to convert Set to Array

    // Iterators and for...of loop (already used in renderTodos, but another example)
    const numbers = [10, 20, 30];
    console.log("for...of loop example:");
    for (const num of numbers) {
        console.log(`  Number: ${num}`);
    }
});