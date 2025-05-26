if(document.getElementById("firstPage")){
function selectItem(id){
    const data = { cartitemid: id };

    fetch('/Sprint1Project/addCartItem', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
}

async function getDate() {
    const response = await fetch('/Sprint1Project/getInitialCartItem');
    const dataobj = await response.json();
    const maindiv = document.querySelector("#cartItems");

    for (const item of dataobj) {
        const div = document.createElement("div");
        const myH2 = document.createElement("h2");
        const myPara1 = document.createElement("p");
        const button = document.createElement("button");
        button.textContent = 'Add to cart';
        button.addEventListener('click' ,() => selectItem(item['cartItemID']));


        myH2.textContent = item['sku'];
        myPara1.textContent = item['finalPrice'];

        div.appendChild(myH2);
        div.appendChild(myPara1);
        div.appendChild(button);
        maindiv.appendChild(div);
    }
}
getDate();
}

if(document.getElementById("secondPage")){

async function getDate() {
    const response = await fetch('/Sprint1Project/addCartItem');
    const dataobj = await response.json();
    const maindiv = document.querySelector("#cartItems");

    for (const item of dataobj) {
        const firstdiv = document.createElement("div");
        firstdiv.className = 'cart-item';
        const seconddiv = document.createElement("div");
        seconddiv.className = "item-image";
        const constImg = document.createElement("img");
        constImg.src = 'https://images.unsplash.com/photo-1581655353564-df123a1eb820?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D';
        constImg.width = 120;
        seconddiv.appendChild(constImg);
        firstdiv.appendChild(seconddiv);
        const thirdDiv = document.createElement("div");
        const myFirsH2 = document.createElement("h2");
        const myNewPara1 = document.createElement("p");
        const myselect = document.createElement("select");
        myFirsH2.textContent = item['sku'];
        myNewPara1.textContent = "Size:";
        firstdiv.appendChild(thirdDiv);
        thirdDiv.appendChild(myFirsH2);
        const choices = ['M','S','L','XL'];
        for(const choice of choices){
            const myoption = document.createElement("option");
            myoption.textContent = choice;
            myselect.appendChild(myoption);
        }
        myNewPara1.appendChild(myselect);
        thirdDiv.appendChild(myNewPara1);
        const p1 = document.createElement("p");
        const p2 = document.createElement("p");
        const p3 = document.createElement("p");
        p1.textContent = "Color: Brown";
        p2.textContent = "Delivery by: Tomorrow";
        p3.textContent = "Quantity:";

        const myselect2 = document.createElement("select");
        const choices2 = ['1','2','3'];

        for(const choice of choices2){
            const myoption = document.createElement("option");
            myoption.textContent = choice;
            myselect2.appendChild(myoption);
        }
        p3.appendChild(myselect2);
        thirdDiv.appendChild(p1);
        thirdDiv.appendChild(p2);
        thirdDiv.appendChild(p3);

        const p4 = document.createElement("p");
        p4.textContent = "Status: ";
        const span1 = document.createElement('span');
        span1.className = "in-stock";
        span1.textContent = "In Stock";
        p4.appendChild(span1);
        thirdDiv.appendChild(p4);
        const label1 = document.createElement('label');
        const input1 = document.createElement("input");
        input1.type = "checkbox";
        input1.textContent = 'This will be a gift';
        label1.appendChild(input1);
        thirdDiv.appendChild(label1);
        const div1 = document.createElement('div');
        div1.className = "buttons";
        const Messages = ['Delete','save for Later','See more like this'];
        for(const message of Messages){
            const button1 = document.createElement('button');
            button1.textContent = message;
            div1.appendChild(button1);
        }
        thirdDiv.appendChild(div1);

          const div2 = document.createElement('div');
          div2.className = 'price-section';
          const p5 = document.createElement('p');
          p5.className = 'price';
          p5.textContent = item['finalPrice']
          const span2 =  document.createElement('span');
          span2.className = "original-price";
          span2.textContent = item['unitPrice'];
          p5.appendChild(span2);
          div2.appendChild(p5);
          thirdDiv.appendChild(div2);
          maindiv.appendChild(firstdiv);
    }

}
async function getTotal(){
    const response = await fetch('/Sprint1Project/getShoppingCart');
    const dataobj = await response.json();
    const maindiv = document.querySelector("#totalPrice");
    const myh3 = document.createElement('h3');
    myh3.textContent = dataobj['cartTotal'];
    maindiv.appendChild(myh3);
}
getDate();
getTotal();
}

