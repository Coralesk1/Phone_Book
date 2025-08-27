async function listAllContacts(){
    try {
        const response = await fetch("http://localhost:8080/api/contacts");
        const data = await response.json(); // pega o JSON retornado
        
        if (Array.isArray(data) && data.length === 0) {
            // caso retorne lista vazia
            document.querySelector(".notebook").innerHTML += `<h2>Banco vazio!</h2>`;
            return;
        }
        if (data.message) {
            // caso retorne mensagem personalizada do backend
            document.querySelector(".notebook").innerHTML += `<h2>${data.message}</h2>`;
            return;
        }

        // Caso tenha contatos
        data.forEach(contact => {
            document.querySelector(".notebook").innerHTML += `<p>${contact.firstName} ${contact.lastName}</p>`;
        });

    } catch (error) {
        document.querySelector(".notebook").innerHTML += `<h2>Erro de conexão</h2>`;
        console.error(error);
    }
}
