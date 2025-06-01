// HOISTING EXAMPLE
console.log("Starting app...");
greet();

function greet() {
    console.log("Welcome to the To-Do App!");
}

// DATA TYPES
let taskInput = document.getElementById("taskInput"); // Object (HTMLInputElement)
let tasks = []; // Array to store tasks

// FUNCTION TO ADD TASK
function addTask() {
    let taskText = taskInput.value; // string - data type

    // CONTROL FLOW STATEMENT
    if (taskText === "") {
        alert("Please enter a task.");
        return;
    }

    // OBJECT
    let task = {
        text: taskText,
        completed: false
    };

    tasks.push(task); // using array
    displayTasks();
    taskInput.value = ""; // Clear input
}

// FUNCTION TO DISPLAY TASKS
function displayTasks() {
    let taskList = document.getElementById("taskList");
    taskList.innerHTML = ""; // Clear existing list

    tasks.forEach((task, index) => {
        let li = document.createElement("li");
        li.textContent = task.text;

        // Button to delete task
        let btn = document.createElement("button");
        btn.textContent = "Delete";
        btn.onclick = function () {
            deleteTask(index);
        };

        li.appendChild(btn);
        taskList.appendChild(li);
    });
}

// FUNCTION TO DELETE TASK
function deleteTask(index) {
    tasks.splice(index, 1); // Remove from array
    displayTasks(); // Re-render
}