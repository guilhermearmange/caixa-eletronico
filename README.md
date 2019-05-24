# Demo de caixa eletrônico

O projeto foi criado utilizando spring boot e gradle e tem como objetivo simular a opção de saque de um caixa eletrônico. Este caixa possui somente notas de 100, 50, 20 e 10 reais e tem como prioridade dar o minimo de notas possível, para isto ele começa sempre distribuindo o máximo de notas maiores possível, e depois vai distribuindo as notas menores conforme necessário.

# Como utilizar
- git clone https://github.com/guilhermearmange/caixa-eletronico.git 
- cd caixa-eletronico 
- ./gradlew build bootRun --args "Valor a Sacar"
    - Exemplo: ./gradlew build bootRun --args "280" 
