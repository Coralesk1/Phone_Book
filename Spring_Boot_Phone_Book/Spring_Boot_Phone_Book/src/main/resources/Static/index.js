function addNewContact() {
  console.log("gya")
  // mostra o form e esconde a lista
  document.querySelector(".div-add").style.display = "block";
  document.querySelector(".div-list").style.display = "none";
  document.querySelector(".div-Specific-list").style.display = "none";
  

  const divAdd = document.querySelector(".div-add");
  divAdd.innerHTML = ''; // limpa antes de recriar

  const div = document.createElement("div");
  div.classList.add("div-inputs-add", "div-bnt");

  div.innerHTML = `
    <div class="div-inputs-add">
      <label for="firstName" class="label-add">First Name</label>
      <input type="text" id="firstName" class="input-add"><br>

      <label for="lastName" class="label-add">Last Name</label>
      <input type="text" id="lastName" class="input-add"><br>

      <label for="email" class="label-add">Email</label>
      <input type="email" id="email" class="input-add"><br>

      <label for="phone" class="label-add">Phone</label>
      <input type="text" id="phone" class="input-add"><br>

      <label for="ddd" class="label-add">DDD</label>
      <input type="text" id="ddd" class="input-add"><br>

      <button class="btn-save" id="bnt-save">Save</button>
    </div>
  `;
  
  divAdd.appendChild(div);

  const btn = document.getElementById("bnt-save");

  // pegar valor de um input
  const firstNameInput = document.getElementById("firstName");
  const lastNameInput = document.getElementById("lastName");
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const dddInput = document.getElementById("ddd");
  
  btn.addEventListener("click", () => {
    
    const dataContact = {
    firstName: firstNameInput.value,
    lastName: lastNameInput.value,
    email: emailInput.value,
    numPhone: phoneInput.value,
    ddd: dddInput.value
    };

    fetch("http://localhost:8080/api/contacts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(dataContact)
    
    });
  }); 
}

async function listAllContacts() {
 
  // mostra lista e esconde o form
  document.querySelector(".div-list").style.display = "block";
  document.querySelector(".div-Specific-list").style.display = "none";
  document.querySelector(".div-add").style.display = "none";

  const divList = document.querySelector(".notebook");
  divList.innerHTML = ''; // limpa tabela antes de renderizar

  try {
    const response = await fetch("http://localhost:8080/api/contacts");
    const data = await response.json();

    console.log(Array.isArray(data));

    if (data.message) { // corrigido 'menssage' para 'message'
      divList.innerHTML = `<h2>Banco vazio!</h2>`;
      return;
    }

    if (Array.isArray(data)) {
      const table = document.createElement("table");

      // cabeçalho
      const header = document.createElement("tr");
      header.innerHTML = `
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>DDD</th>
      `;
      table.appendChild(header);

      // dados
      data.forEach(contact => {
        const contactData = document.createElement("tr");
        contactData.innerHTML = `
          <td>${contact.firstName}</td>
          <td>${contact.lastName}</td>
          <td>${contact.email}</td>
          <td>${contact.numPhone}</td>
          <td>${contact.ddd}</td>
        `;
        table.appendChild(contactData);
      });

      divList.appendChild(table);
    }
  } catch (error) {
    divList.innerHTML = `<h2>Erro de conexão com o servidor</h2>`;
    console.error(error);
  }
}

function ListSpecificContact(){

  document.querySelector(".div-list").style.display = "none";
  document.querySelector(".div-Specific-list").style.display = "block";
  document.querySelector(".div-add").style.display = "none";

  console.log("entrei na funcao");
  const divSList = document.querySelector(".div-Specific-list");
  divSList.innerHTML = '';

  const div = document.createElement("div");
  div.classList.add("div-input-id");

  div.innerHTML = `
    <div class="div-input-id">
      <label class="label-id">What is the Id</label>
      <input id="valueInput" type="Number" class="input-id">
    </div>
  
  `;
  
  /* try {
    const response = await fetch('http://localhost:8080/api/contacts/${valueInput}');
  } */

  divSList.appendChild(div);
  const valueInput = document.getElementById("valueInput").value;
  console.log(document.getElementById("valueInput").value);
 

};
