let currentFilter: 'all' | 'active' | 'completed' = 'all';

const todoInput = document.getElementById('todo-input') as HTMLInputElement;
const addTodoBtn = document.getElementById('add-todo-btn') as HTMLButtonElement;
const todoListUl = document.getElementById('todo-list') as HTMLUListElement;
const clearCompletedBtn = document.getElementById('clear-completed-btn') as HTMLButtonElement;
const filterButtons = document.querySelector('.filters') as HTMLElement;

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

type TodoID = number;

type TodoItemType = {
    id: TodoID;
    text: string;
    completed: boolean;
    createdAt: Date;
    priority?: Priority;
};

type OptionalTodo = TodoItemType | undefined;

let todosMap: Map<TodoID, TodoItemType> = new Map();

function createTodo(text: string): TodoItemType {
    return {
        id: Date.now(),
        text: text,
        completed: false,
        createdAt: new Date()
    };
}

function renderTodos(): void {
    todoListUl.innerHTML = '';
    let todos = Array.from(todosMap.values());

    if (currentFilter === 'active') {
        todos = todos.filter(t => !t.completed);
    } else if (currentFilter === 'completed') {
        todos = todos.filter(t => t.completed);
    }

    if (todos.length === 0) {
        todoListUl.innerHTML = `<li><span>No todos found.</span></li>`;
        return;
    }

    for (let todo of todos) {
        const li = document.createElement('li');
        li.classList.add('todo-item');
        if (todo.completed) li.classList.add('completed');
        li.dataset.id = todo.id.toString();

        li.innerHTML = `
            <input type="checkbox" ${todo.completed ? 'checked' : ''}>
            <span>${todo.text}</span>
            <button class="delete-btn">Delete</button>
        `;

        todoListUl.appendChild(li);
    }
}

addTodoBtn.addEventListener('click', () => {
    const val = todoInput.value.trim();
    if (val !== '') {
        const newTodo = createTodo(val);
        todosMap.set(newTodo.id, newTodo);
        saveTodos().then(() => renderTodos());
        todoInput.value = '';
    }
});

todoListUl.addEventListener('click', (e) => {
    const target = e.target as HTMLElement;
    const li = target.closest('li') as HTMLLIElement;

    if (!li) return;

    const id = parseInt(li.dataset.id!);
    const todo = todosMap.get(id);

    if (!todo) return;

    if (target instanceof HTMLInputElement && target.type === 'checkbox') {
        todo.completed = target.checked;
    } else if (target.classList.contains('delete-btn')) {
        todosMap.delete(id);
    }

    saveTodos().then(() => renderTodos());
});

clearCompletedBtn.addEventListener('click', () => {
    todosMap = new Map(Array.from(todosMap.entries()).filter(([_, todo]) => !todo.completed));
    saveTodos().then(() => renderTodos());
});

filterButtons.addEventListener('click', (e) => {
    const target = e.target as HTMLButtonElement;
    if (target.tagName !== 'BUTTON') return;

    Array.from(filterButtons.children).forEach(btn => btn.classList.remove('active'));
    target.classList.add('active');

    const parts = target.id.split('-');
    currentFilter = parts[1] as 'all' | 'active' | 'completed';

    renderTodos();
});

function saveTodos(): Promise<void> {
    return new Promise((res) => {
        const all = Array.from(todosMap.values()).map(t => ({
            ...t,
            createdAt: t.createdAt.toISOString()
        }));
        localStorage.setItem('todos', JSON.stringify(all));
        res();
    });
}

function loadTodos(): Promise<void> {
    return new Promise((res) => {
        const saved = localStorage.getItem('todos');
        if (saved) {
            const parsed = JSON.parse(saved);
            for (let d of parsed) {
                const t: TodoItemType = {
                    id: d.id,
                    text: d.text,
                    completed: d.completed,
                    createdAt: new Date(d.createdAt)
                };
                todosMap.set(t.id, t);
            }
        }
        res();
    });
}

document.addEventListener('DOMContentLoaded', () => {
    loadTodos().then(() => renderTodos());
});

// GENERICS (simple)
function wrapThing<T>(thing: T): T[] {
    return [thing];
}
const ex1 = wrapThing("hey");

// TYPE GUARD
function isString(val: unknown): val is string {
    return typeof val === 'string';
}
