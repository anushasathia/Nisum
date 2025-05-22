const user = {
    name: "Alice",
    age: 25,
    email: "alice@example.com"
  };
  
  for (let key in user) {
    console.log(`${key}: ${user[key]}`);
  }
  