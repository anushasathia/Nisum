const todoInput = document.getElementById('todo-input');
const addTodoBtn = document.getElementById('add-todo-btn');
const todoListUl = document.getElementById('todo-list');
const clearCompletedBtn = document.getElementById('clear-completed-btn');
const filterButtons = document.querySelector('.filters');

let todosMap = new Map();
let currentFilter = 'all';

const TODO_ID_SYMBOL = Symbol('todoUniqueId');
const STORAGE_KEY = Symbol('todoListStorageKey');

class TodoItem {
    text;
    isCompleted;
    id;
    createdAt;

    static *idGenerator() {
        let id = Date.now();
        while (true) {
            yield id++;
        }
    }
    static generatorInstance = TodoItem.idGenerator();

    constructor(text, completed = false, id = TodoItem.generatorInstance.next().value) {
        this.text = text;
        this.isCompleted = completed;
        this.id = id;
        this.createdAt = new Date();
        this[TODO_ID_SYMBOL] = id;
    }

    get completed() {
        return this.isCompleted;
    }

    set completed(value) {
        if (typeof value === 'boolean') {
            this.isCompleted = value;
        } else {
            console.warn("Completed status must be a boolean.");
        }
    }

    toggleCompleted() {
        this.isCompleted = !this.isCompleted;
    }

    toPlainObject() {
        const { text, isCompleted: completed, id, createdAt } = this;
        return { text, completed, id, createdAt: createdAt.toISOString() };
    }
}

const elementMetadata = new WeakMap();

const setElementMetadata = (element, key, value) => {
    let data = elementMetadata.get(element) || {};
    data[key] = value;
    elementMetadata.set(element, data);
};

const processedElements = new WeakSet();

const markElementAsProcessed = (element) => {
    processedElements.add(element);
};

const saveTodos = () => {
    return new Promise(resolve => {
        setTimeout(() => {
            const todosArray = Array.from(todosMap.values()).map(todo => todo.toPlainObject());
            localStorage.setItem(STORAGE_KEY.description, JSON.stringify(todosArray));
            console.log("Todos saved!");
            resolve();
        }, 100);
    });
};

const loadTodos = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            try {
                const storedTodos = localStorage.getItem(STORAGE_KEY.description);
                if (storedTodos) {
                    const parsedTodos = JSON.parse(storedTodos);
                    todosMap = new Map(
                        Array.from(parsedTodos, data => {
                            const { text, completed, id } = data;
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

const renderTodos = () => {
    todoListUl.innerHTML = '';
    let displayedTodos = Array.from(todosMap.values());

    if (currentFilter === 'active') {
        displayedTodos = displayedTodos.filter(todo => !todo.completed);
    } else if (currentFilter === 'completed') {
        displayedTodos = displayedTodos.filter(todo => todo.completed);
    }

    if (displayedTodos.length === 0) {
        todoListUl.innerHTML = `<li class="todo-item"><span style="color: #666;">No todos to display for this filter.</span></li>`;
        return;
    }

    for (const todo of displayedTodos) {
        const li = document.createElement('li');
        li.classList.add('todo-item');
        if (todo.completed) {
            li.classList.add('completed');
        }
        li.dataset.id = todo.id;

        li.innerHTML = `
            <input type="checkbox" ${todo.completed ? 'checked' : ''}>
            <span>${todo.text}</span>
            <button class="delete-btn">Delete</button>
        `;

        setElementMetadata(li, 'todoInstance', todo);

        todoListUl.appendChild(li);
    }
};

addTodoBtn.addEventListener('click', () => {
    const text = todoInput.value.trim();
    if (text) {
        const newTodo = new TodoItem(text);
        todosMap.set(newTodo.id, newTodo);
        saveTodos().then(renderTodos);
        todoInput.value = '';
        console.log("Added todo:", newTodo);
    }
});

todoListUl.addEventListener('click', (event) => {
    const target = event.target;
    const listItem = target.closest('.todo-item');

    if (!listItem) return;

    const todoId = parseInt(listItem.dataset.id);
    const todo = todosMap.get(todoId);

    if (!todo) return;

    if (target.type === 'checkbox') {
        const isChecked = Object.is(target.checked, true);
        todo.completed = isChecked;
        saveTodos().then(renderTodos);
        markElementAsProcessed(listItem);
    } else if (target.classList.contains('delete-btn')) {
        todosMap.delete(todoId);
        saveTodos().then(renderTodos);
    }
});

clearCompletedBtn.addEventListener('click', () => {
    todosMap = new Map(
        Array.from(todosMap.entries()).filter(([id, todo]) => !todo.completed)
    );
    saveTodos().then(renderTodos);
});

filterButtons.addEventListener('click', (event) => {
    const target = event.target;
    if (target.tagName === 'BUTTON') {
        Array.from(filterButtons.children).forEach(btn => btn.classList.remove('active'));
        target.classList.add('active');
        const [_, filterType] = target.id.split('-');
        currentFilter = filterType;
        renderTodos();
    }
});

document.addEventListener('DOMContentLoaded', () => {
    loadTodos().then(renderTodos);

    const statusMessages = Array.of("App initialized", "Ready to add todos!");
    console.log("Array.of example:", statusMessages);

    const defaultTodoData = { text: "Learn JS", completed: false };
    const urgentTodoData = Object.assign({}, defaultTodoData, { priority: "high", dueDate: "today" });
    console.log("Object.assign example:", urgentTodoData);

    const anotherUrgentTodoData = { ...defaultTodoData, priority: "very high" };
    console.log("Spread Operator (object) example:", anotherUrgentTodoData);

    function logManyArgs(prefix, ...args) {
        console.log(`${prefix}:`, ...args);
    }
    logManyArgs("Debugging Info", "Application started", 123, { status: "OK" });

    const tags = new Set(['coding', 'work', 'coding', 'personal']);
    console.log("Set example (unique tags):", Array.from(tags));

    const numbers = [10, 20, 30];
    console.log("for...of loop example:");
    for (const num of numbers) {
        console.log(`  Number: ${num}`);
    }
});