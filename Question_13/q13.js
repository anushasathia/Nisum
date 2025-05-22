async function fetchData() {
    try {
      const response = await fetch('https://api.publicapis.org/entries');
      if (!response.ok) throw new Error('Network response was not ok');
      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error('Fetch error:', error);
    }
  }
  
  fetchData();