Cadastro de alunos da escola de mágia de Harry Potter.
Criar um microserviço com dois endpoints.
Um endpoint (POST) para o cadastro do aluno: Ao cadastrar o aluno deverá ser consultado um serviço web que informar a qual casa este aluno pertence.
https://api-harrypotter.herokuapp.com/sortinghat.
Somente a chave deverá ser persistida na base de dados do microserviço, em conjunto com as informações do aluno.
- ID
- Nome
- Serie
- chave da casa seletora
Um endpoint (GET) passando path param contendo a chave primaria do aluno. informe todas as informações do aluno além da casa ao qual ele pertence. Para este último deverá se consultado o endpoint contendo a chave da casa ao qual se deseja ter as informações.
https://api-harrypotter.herokuapp.com/sortinghat.
https://api-harrypotter.herokuapp.com/house/{chavecasa}
