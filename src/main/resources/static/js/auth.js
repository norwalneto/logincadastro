document.addEventListener('DOMContentLoaded', function () {

    // Referências aos elementos do DOM para login
    const loginForm = document.getElementById('login-form');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');

    // Referências aos elementos do DOM para cadastro
    const signupForm = document.getElementById('signup-form');
    const signupEmailInput = document.getElementById('signup-email');
    const signupPasswordInput = document.getElementById('signup-password');

    // Evento de submissão do formulário de Login
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Coleta os valores dos inputs
        const email = emailInput.value;
        const password = passwordInput.value;

        // Envio dos dados para o backend (processo de login)
        fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        })
            .then(response => response.json()) // Espera a resposta em formato JSON
            .then(data => {
                if (data.success) {
                    alert('Login bem-sucedido!');
                    window.location.href = '/dashboard'; // Redireciona para a página principal
                } else {
                    alert('Erro no login. Verifique suas credenciais.');
                }
            })
            .catch(error => {
                console.error('Erro na requisição de login:', error);
                alert('Erro ao tentar realizar o login. Tente novamente.');
            });
    });

    // Evento de submissão do formulário de Cadastro
    signupForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Coleta os valores dos inputs
        const email = signupEmailInput.value;
        const password = signupPasswordInput.value;

        // Verifica se a resposta está no formato esperado
        fetch('http://localhost:8080/api/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        })
            .then(response => {
                if (!response.ok) {
                    // Lida com o erro HTTP se a resposta não for "ok"
                    throw new Error('Erro na requisição de cadastro: ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                if (data.success) {
                    alert('Cadastro realizado com sucesso!');
                    window.location.href = '/login'; // Redireciona para a página de login
                } else {
                    alert('Erro no cadastro. Tente novamente.');
                }
            })
            .catch(error => {
                console.error('Erro na requisição de cadastro:', error);
                alert('Erro ao tentar realizar o cadastro. Tente novamente.');
            });
    });
});
