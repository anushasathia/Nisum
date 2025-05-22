fetch('https://jsonplaceholder.typicode.com/users')
  .then(response => response.json())
  .then(users => {
    users.forEach(user => {
      console.log(`${user.name} - ${user.email}`);
    });
  })
  .catch(error => console.error('Error fetching users:', error));

