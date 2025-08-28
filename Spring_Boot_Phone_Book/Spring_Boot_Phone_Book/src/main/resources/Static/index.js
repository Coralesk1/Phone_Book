async function listAllContacts() {
    console.log("entrei na chamada da função");
    try {
        const response = await fetch("http://localhost:8080/api/contacts");

        // Recebe e converte a resposta para um objeto JavaScript (JSON)
        const data = await response.json(); 
       
        // 1. Verifica se a resposta é um objeto com a propriedade 'message'
        if (data.menssage) {
            document.querySelector(".notebook").innerHTML = `<h2>Banco vazio!</h2>`;
            return;
           
        }
        
    } catch (error) {
        document.querySelector(".notebook").innerHTML = `<h2>Erro de conexão</h2>`;
        console.error(error);
    }
}