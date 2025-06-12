# Static Checker - CangaCode2025-1

Este projeto é um analisador léxico (Static Checker) desenvolvido para a linguagem CangaCode2025-1, conforme a especificação do curso de Compiladores da UCSal.

---

## Requisitos

### 1. Java JDK 17 ou superior

## Como instalar o Java JDK

1. Acesse: https://www.oracle.com/br/java/technologies/downloads/
2. Siga as instruções para realizar o download
4. Reinicie o terminal

### Checando se a instalação foi bem sucedida:
Abra o terminal (CMD, PowerShell ou Terminal Linux/Mac) e digite:

```
java -version
```

Você deve ver a versão instalada exibida

## Estrutura esperada do projeto

Coloque os seguintes arquivos na mesma pasta:

```
/StaticChecker/
├── StaticChecker.jar
├── ExecutarStaticChecker.bat    (opcional para execução com duplo clique)
├── MeuTeste.251                 arquivo fonte a ser analisado
```

---

## Como executar


### Opção 1: Via terminal
```bash
java -jar StaticChecker.jar MeuTeste
```

(O programa buscará o arquivo `MeuTeste.251` automaticamente)

---

### Opção 2: Com duplo clique

1. Dê duplo clique no arquivo `ExecutarStaticChecker.bat`
2. Digite o nome base do arquivo `.251` (ex: `MeuTeste`)

---

## Saídas geradas

Após a execução, o programa cria dois arquivos na mesma pasta:

- `MeuTeste.LEX` – Relatório da análise léxica
- `MeuTeste.TAB` – Relatório da tabela de símbolos

---
