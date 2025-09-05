function addNewContact() {
  console.log("adicionar contato");

  // mostra o form e esconde a lista
  document.querySelector(".div-add").style.display = "block";
  document.querySelector(".div-list").style.display = "none";

  const addContainer = document.querySelector(".div-add");
  addContainer.innerHTML = ''; // limpa antes de recriar

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
    </div>
  `;
  
    div.innerHTML += `<button class="btn-save">Save</button>`;
    addContainer.appendChild(div);

    const inputs = div.querySelectorAll("input");

    // pegar valor de um input
    const firstNameInput = document.getElementById("firstName");
    firstNameInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        console.log(firstNameInput.value);
    }
    });

    const lastNameInput = document.getElementById("lastName");
    lastNameInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        console.log(lastNameInput.value);
    }
    });

    const emailInput = document.getElementById("email");
    emailInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        console.log(emailInput.value);
    }
    });

    const phoneInput = document.getElementById("phone");
    phoneInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        console.log(phoneInput.value);
    }
    });

    const dddInput = document.getElementById("ddd");
    dddInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        console.log(dddInput.value);
    }
    });

    /* dddInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        const dataContact = {
        firstName: firstNameInput.value,
        lastName: lastNameInput.value,
        email: emailInput.value,
        numPhone: phoneInput.value,
        ddd: dddInput.value
        };

        const dataJson = JSON.stringify(dataContact);
        console.log(dataJson);
    }
    }); */ //ESTUDAR ISSO AQUI 

}

async function listAllContacts() {
  console.log("entrei na chamada da função");

  // mostra lista e esconde o form
  document.querySelector(".div-add").style.display = "none";
  document.querySelector(".div-list").style.display = "block";

  const notebook = document.querySelector(".notebook");
  notebook.innerHTML = ''; // limpa tabela antes de renderizar

  try {
    const response = await fetch("http://localhost:8080/api/contacts");
    const data = await response.json();

    console.log(Array.isArray(data));

    if (data.message) { // corrigido 'menssage' para 'message'
      notebook.innerHTML = `<h2>Banco vazio!</h2>`;
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

      notebook.appendChild(table);
    }
  } catch (error) {
    notebook.innerHTML = `<h2>Erro de conexão</h2>`;
    console.error(error);
  }
}
