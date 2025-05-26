async function loadData(){
    const url = '/Sprint1Project/addCartItem';
    const response = await fetch(url);
    const dataobj = await response.json();
    const mainSection = document.querySelector("#odersdetails");
    for(const item of dataobj){
        const div = document.createElement('div');
        div.className = 'order';
        const myh3 = document.createElement('h3');
        myh3.textContent = item['sku']
        const myp1 = document.createElement('p');
        myp1.textContent = "Size : M | Color: Blue | Qty : 1"
        const myp2 = document.createElement('p');
        myp2.textContent = "delivery by : 25th May 2025"
        div.appendChild(myh3);
        div.appendChild(myp1);
        div.appendChild(myp2);
        mainSection.appendChild(div);
    }

}
loadData();

async function RestartCart(){
    const url = '/Sprint1Project/Restart';
    await fetch(url ,{ method: 'DELETE' })
}