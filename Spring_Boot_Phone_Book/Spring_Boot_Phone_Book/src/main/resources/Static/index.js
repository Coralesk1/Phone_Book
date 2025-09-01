function addNewContact() {
   
    console.log("adiconar contato");

    const mainContainer = document.querySelector(".div-notebook");
    mainContainer.innerHTML = ''; 

    const div = document.createElement("div");
    div.classList.add("div-inputs-add");
    div.classList.add("div-bnt");
    

    div.innerHTML += `
        <div class="div-inputs-add">

            <label for="firstName" class="label-add">First Name</label>
            <input type="text" id="firstName" class="input-add"><br>

            <label for="lastName" class="label-add">Last Name</label>
            <input type="text" id="lastName" class="input-add"><br>

            <label for="email" class="label-add">Email</label>
            <input type="email" id="email" class="input-add"><br>

            <label for="phone" class="label-add">Phone</label>
            <input type="email" id="phone" class="input-add"><br>

            <label for="ddd" class="label-add">DDD</label>
            <input type="text" id="ddd" class="input-add"><br>

            
        </div>
        
    `;

    div.innerHTML += `<button onclick="" class="btn-save">Save</button>`;

    mainContainer.appendChild(div); //adicionar a div no notebook
    

    div.querySelector()
    const firstName = document.getElementById("firstName").value;
    console.log(firstName);
}


async function listAllContacts() {
    console.log("entrei na chamada da função");

    const mainContainer = document.querySelector(".notebook");
    mainContainer.innerHTML = ''; 

  
    try {
        const response = await fetch("http://localhost:8080/api/contacts");

        // Recebe e converte a resposta para um objeto JavaScript (JSON)
        const data = await response.json(); 
        
        console.log(Array.isArray(data));
        // 1. Verifica se a resposta é um objeto com a propriedade 'message'
        if (data.menssage) {
            notebook.innerHTML = `<h2>Banco vazio!</h2>`;
            return;
        }
        if (Array.isArray(data)){
            
            notebook.innerHTML = "";
            const table = document.createElement("table");

            // cabeçalho
            const header = document.createElement("tr");
            header.innerHTML = "<th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>DDD</th>";
            table.appendChild(header);

            //dados da tabela
            data.forEach(contact => {
                const contactData = document.createElement("tr");
                contactData.innerHTML = `<td>${contact.firstName}</td>
                                    <td>${contact.lastName}</td>
                                    <td>${contact.email}</td>
                                    <td>${contact.numPhone}</td>
                                    <td>${contact.ddd}</td>`;
                table.appendChild(contactData);
            });
            notebook.appendChild(table);
           
        }
        
    } catch (error) {
        document.querySelector(".notebook").innerHTML = `<h2>Erro de conexão</h2>`;
        console.error(error);
    }
}
