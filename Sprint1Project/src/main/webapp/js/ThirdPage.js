function deliverToAddress(addressID) {
    sessionStorage.setItem('selectedAddressID', addressID);
    window.location.href = "../pages/FourthPage.html";
}

async function loadData(){
        const response = await fetch('/Sprint1Project/UserAddress');
        const dataobj = await response.json();
        const mainbody = document.querySelector("#addressList");
        for(const address of dataobj){
        const div1 = document.createElement('div');
        div1.className = 'address-card';
        const input1 = document.createElement('input');
        input1.type = 'radio';
        input1.name = 'address';
        div1.appendChild(input1);
        const div2 = document.createElement('div');
        div2.className = 'address-info';
        const strong1 = document.createElement('strong');
        strong1.textContent = "Name Not Given";
        const p1 = document.createElement('p');
        p1.textContent = address['addressLine1'];
        const p2 = document.createElement('p');
        p2.textContent = address['addressLine2'];
        const p3 = document.createElement('p');
        p3.textContent = address['state'] + ', ' + address["country"] + ' - ' + address['zipcode'];
        div2.appendChild(strong1);
        div2.appendChild(p1);
        div2.appendChild(p2);
        div2.appendChild(p3);
        div1.appendChild(div2);
        const button = document.createElement('button');
        button.className = 'deliver-btn';
        button.textContent = 'Deliver to this address'

        button.addEventListener('click', () => deliverToAddress(address['addressId']));
        div1.appendChild(button);
        mainbody.appendChild(div1);
        }

}
loadData();

