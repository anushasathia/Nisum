async function executeTasksInOrder(taskList) {
    const output = [];
  
    for (let i = 0; i < taskList.length; i++) {
      const currentTask = taskList[i];
      try {
        const res = await currentTask();
        output.push(res);
      } catch (err) {
        console.error("An error occurred:", err);
      }
    }
  
    return output;
  }
  
  const taskList = [
    () => Promise.resolve("Completed Task 1"),
    () => Promise.reject("Error in Task 2"),
    () => Promise.resolve("Completed Task 3"),
  ];
  
  executeTasksInOrder(taskList).then(result => {
    console.log("Final Results:", result);
  });
  