const selectedAddressID = sessionStorage.getItem('selectedAddressID');

console.log(selectedAddressID);
async function loadData(){
      const url = `/Sprint1Project/UserAddress?id=${selectedAddressID}`;
      const response = await fetch(url);
      const dataobj = await response.json();

      const div = document.querySelector('.billing-address-box');
      const p1 = document.createElement("p");
      p1.textContent = "No Name Given";
    const p2 = document.createElement('p');
    p2.textContent = dataobj['addressLine1'];
    const p3 = document.createElement('p');
    p3.textContent = dataobj['addressLine2'];
    const p4 = document.createElement('p');
    p4.textContent = dataobj['state'] + ', ' + dataobj["country"] + ' - ' + dataobj['zipcode'];
    div.appendChild(p1);
    div.appendChild(p2);
    div.appendChild(p3);
    div.appendChild(p4);
}

loadData();