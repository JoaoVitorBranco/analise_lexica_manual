# analise_lexica_manual

## Estruturação do Código

## Objetivos
- Identificação de uma sequência de caracteres, realizando uma análise léxica em Java.

### Marcas/TAGs
1. Palavras Reservadas 🟩🟩
    - if
    - else
    - while
    - do
    - int
    - char
    - void

2. Identificador 🟩🟩
    - pelo menos uma letra seguida de zero ou mais letras ou dígitos
    - nomes de variáveis
    - _ex_: banana
    - _ex_: aux
    - _ex_: v1
    - _ex_: v42069

3. Constante Inteira 🟩
    - sinal + ou ‐ opcional seguido de pelo menos um dígito
    - _ex_: 1
    - _ex_: 0
    - _ex_: -101
    - _ex_: +202

4. Constante Hexadecimal 🟩
    - o prefixo 0x ou 0X seguido de um ou mais dígitos ou letras maiúsculas entre A à F ou letras minúsculas entre a à f
    - _ex_: 0xa
    - _ex_: 0x123Af
    - _ex_: 0X123eaB
    
5. Constante Octal 🟩
    - o prefixo 0 seguido de um ou mais dígitos no intervalo de 0 à 7
    - _ex_: 0123
    - _ex_: 00
    - _ex_: 000

6. Constante Real 🟩
    - sinal + ou ‐, ser seguido por um ou mais dígitos, depois ser seguido pelo símbolo . (ponto) e então por um ou mais dígitos. Por fim, opcionalmente, pode ter a letra E ou e, seguido por opcionalmente pelo sinal + ou ‐ e obrigatoriamente por uma sequência
    - _ex_: +1.3
    - _ex_: 5.0e10
    - _ex_: 6.02E+23

de um ou mais dígitos

7. Cadeias de Caracteres 🟩🟩
    - qualquer sequência de zero ou mais caracteres ladeado por " e"
    - _ex_: "isasdADS\ \*\*\\d@0129yu398nosdh0123>:???>?>^''''''^}d~]aç]sdças\]      \\n\n\nn\nn\n/-/*"
    
8. Caractere 🟩🟩
    - qualquer caractere simples (apenas um!) ladeado por ' e '
    - _ex_: 'a'
    - _ex_: '2'

9. Operadores 🟩
    - Qualquer símbolo dentro deste conjunto: ‐>, ++, ‐‐, &, *, +, ‐, ,̃ !
    - _ex_: ->
    - _ex_: ++
    - _ex_: --
    - _ex_: &
    - _ex_: *
    - _ex_: +
    - _ex_: -
    - _ex_: ~
    - _ex_: !

10. Pontuadores 🟩🟩
    - Qualquer símbolo dentro deste conjunto: [, ], (, ), ,
    - _ex_: [
    - _ex_: ]
    - _ex_: (
    - _ex_: )
    - _ex_: ,
    - _ex_: ; 

## Observações
1. Ignorar espaçis em branco

2. Apontar Erro

## Pendentes




vitor 1 0x120123ASedasd "0129u3091d" @ -- {}
