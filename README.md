# Caixa eletrônico

Este projeto foi criado para simular o funcionamento de um caixa eletrônico. O sistema funciona seguindo as seguintes regras:
* Entregar o menor número de notas;
* É possível sacar o valor solicitado com as notas disponíveis;
* Saldo do cliente infinito;
* Quantidade de notas finito;
* Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00

O desenvolvimento deste projeto foi divido em duas etapas, primeiramente a modelagem das classes e implementação para realizar o saque sem considerar o limite de notas. Posteriormente foi desenvolvido a validação de notas disponíveis no caixa eletrônico.

As tecnologias utilizadas para desenvolver este projeto foram: 
* Java 8
* Spring Boot
* Gradle
* JUnit

# Como utilizar
- git clone https://github.com/guilhermearmange/caixa-eletronico.git 
- cd caixa-eletronico 
- ./gradlew build bootRun --args "Valor a Sacar"
    - Exemplo: ./gradlew build bootRun --args "280 500" 
- Para alterar a quantidade de notas disponíveis pode ser utilizadas as configurações(notas.cem, notas.cinquenta, notas.vinte, notas.dez) do application.yml