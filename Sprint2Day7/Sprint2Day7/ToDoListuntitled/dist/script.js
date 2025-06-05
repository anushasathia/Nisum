"use strict";
let currentFilter = 'all';
const todoInput = document.getElementById('todo-input');
const addTodoBtn = document.getElementById('add-todo-btn');
const todoListUl = document.getElementById('todo-list');
const clearCompletedBtn = document.getElementById('clear-completed-btn');
const filterButtons = document.querySelector('.filters');
var Priority;
(function (Priority) {
    Priority[Priority["LOW"] = 0] = "LOW";
    Priority[Priority["MEDIUM"] = 1] = "MEDIUM";
    Priority[Priority["HIGH"] = 2] = "HIGH";
})(Priority || (Priority = {}));
let todosMap = new Map();
function createTodo(text) {
    return {
        id: Date.now(),
        text: text,
        completed: false,
        createdAt: new Date()
    };
}
function renderTodos() {
    todoListUl.innerHTML = '';
    let todos = Array.from(todosMap.values());
    if (currentFilter === 'active') {
        todos = todos.filter(t => !t.completed);
    }
    else if (currentFilter === 'completed') {
        todos = todos.filter(t => t.completed);
    }
    if (todos.length === 0) {
        todoListUl.innerHTML = `<li><span>No todos found.</span></li>`;
        return;
    }
    for (let todo of todos) {
        const li = document.createElement('li');
        li.classList.add('todo-item');
        if (todo.completed)
            li.classList.add('completed');
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
    const target = e.target;
    const li = target.closest('li');
    if (!li)
        return;
    const id = parseInt(li.dataset.id);
    const todo = todosMap.get(id);
    if (!todo)
        return;
    if (target instanceof HTMLInputElement && target.type === 'checkbox') {
        todo.completed = target.checked;
    }
    else if (target.classList.contains('delete-btn')) {
        todosMap.delete(id);
    }
    saveTodos().then(() => renderTodos());
});
clearCompletedBtn.addEventListener('click', () => {
    todosMap = new Map(Array.from(todosMap.entries()).filter(([_, todo]) => !todo.completed));
    saveTodos().then(() => renderTodos());
});
filterButtons.addEventListener('click', (e) => {
    const target = e.target;
    if (target.tagName !== 'BUTTON')
        return;
    Array.from(filterButtons.children).forEach(btn => btn.classList.remove('active'));
    target.classList.add('active');
    const parts = target.id.split('-');
    currentFilter = parts[1];
    renderTodos();
});
function saveTodos() {
    return new Promise((res) => {
        const all = Array.from(todosMap.values()).map(t => (Object.assign(Object.assign({}, t), { createdAt: t.createdAt.toISOString() })));
        localStorage.setItem('todos', JSON.stringify(all));
        res();
    });
}
function loadTodos() {
    return new Promise((res) => {
        const saved = localStorage.getItem('todos');
        if (saved) {
            const parsed = JSON.parse(saved);
            for (let d of parsed) {
                const t = {
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
function wrapThing(thing) {
    return [thing];
}
const ex1 = wrapThing("hey");
// TYPE GUARD
function isString(val) {
    return typeof val === 'string';
}
