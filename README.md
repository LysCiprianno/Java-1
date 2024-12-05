# Caixa Eletrônico em Java

Este é um simples projeto de **Caixa Eletrônico** em Java. O código implementa um sistema básico de interações com um caixa eletrônico, onde o usuário pode criar contas, consultar saldo, fazer saques, depósitos, transferências e visualizar o extrato.

O código simula o comportamento de um caixa eletrônico com várias funcionalidades, e foi feito com o objetivo de praticar conceitos como controle de fluxo, manipulação de dados e validação de entradas no Java.

## Funcionalidades

- **Criar Conta**: O usuário pode criar uma conta, fornecendo um número fictício de conta.
- **Consultar Saldo**: O usuário pode consultar seu saldo, mas apenas após inserir a senha correta.
- **Extrato**: O sistema mantém um extrato de todas as operações realizadas, como saques, depósitos e transferências.
- **Saque**: O usuário pode realizar saques, com algumas validações de segurança:
  - O valor do saque não pode ser menor ou igual a zero.
  - O valor do saque não pode ser maior que o saldo disponível.
- **Depósito**: O usuário pode realizar depósitos, mas o valor não pode ser menor ou igual a zero.
- **Transferência**: O usuário pode transferir dinheiro para outra conta. A transferência tem as mesmas validações do saque, ou seja, o valor deve ser maior que zero e não pode exceder o saldo.
- **Senha de Acesso**: Para realizar algumas operações (como consultar saldo, realizar saques, transferências e ver o extrato), o usuário precisa inserir uma senha. A senha padrão é **3589**.

## Como Funciona?

### 1. **Abertura do Sistema**
Quando você acessar o sistema pela primeira vez, será solicitado o seu nome. Após digitar o nome, o sistema vai dar as boas-vindas com uma mensagem personalizada.

### 2. **Menu de Opções**
Após a inicialização, o sistema exibe um menu com as seguintes opções:

1. Criar Conta
2. Saldo
3. Extrato
4. Saque
5. Depósito
6. Transferência
7. Sair

Você pode escolher a opção que deseja utilizando o número correspondente. Para cada operação que envolva consultar saldo, realizar saques ou transferências, você precisará inserir a senha.

### 3. **Validações Importantes**
O sistema possui validações que garantem que as operações sejam realizadas de forma segura. Por exemplo:
- **Saque**: O valor de saque não pode ser maior que o saldo disponível, nem menor ou igual a zero.
- **Transferência**: Semelhante ao saque, o valor da transferência não pode ser maior que o saldo disponível, nem menor ou igual a zero.
- **Depósito**: O valor do depósito deve ser maior que zero.

### 4. **Encerramento**
Quando o usuário escolher a opção "Sair", o sistema exibirá uma mensagem de despedida e o programa será encerrado.

