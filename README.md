# ATG-2018.2
Projeto de Aplicações de Teoria dos Grafos

Incluir no build path (agora já inclusos no diretorio do projeto, na pasta "src"):
  - jgraphx.jar
  - jgrapht-io-1.2.0.jar
  - jgrapht-ext-1.2.0.jar
  - jgrapht-core-1.2.0.jar

Para executar o código, use os seguintes arquivos:
  - problema1.Main1.java
  - problema2.Main2.java
  - problema3.Main3.java
  
Caso haja NullPointerException na execução:
  Seu sistema não reconhece o endereço do arquivo ATG.csv na pasta src do projeto. Mude manualmente o endereço apontado pela constante FILE_ADDRESS no arquivo "SourceAdapterX" (onde X é referente ao pacote "problemaX(alt)" onde a classe se encontra.
  
O pacote jgrapht contem apenas as classes auxiliares que permitem a leitura do arquivo CSV e uma classe Main para testes rápidos.
