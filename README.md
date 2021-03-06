# projeto_web_2

## Projeto da Disciplina Desenvolvimento WEB II - UFRN

Serviço de agendamento dos equipamentos do laboratório do Centro de Biociências da UFRN.

Esta API desenvolvida em SpringBoot deverá fazer a comunicação entre o sistema de reserva de equipamentos dos laboratórios do Centro de Biociências da Universidade com o servidor web, e a API da universidade(Credenciamento).


### Autores:
- Lucédio de Oliveira Cândido
- Vanessa Sayuri Uchida

### Endpoints
  - Reservar horário para uso de equipamento
  - Cancelar reservas de equipamentos 
  - Consultar reservas
  - Estabelecer a comunicação com a API da ufrn para utilizar dados de login do SIGAA.  
  - Indicar interesse em reservar equipamento já reservado (Lista de espera, sendo a reserva for cancelada, o usuario receberá notficação)


### Estórias de usuário

#### Usuário pesquisador
- Sendo um usuário do laboratório eu desejo:
    - Reservar horários para utilização de equipamento dos loboratórios
    - Cancelar minhas reservas
    - Declarar meu interesse em reservar equipamentos já reservados(Lista de espera para uso do equipamento)
    - Consultar quais equipamentos estão disponíveis na data e no horário que desejo
    
 #### Usuário técnico de um laboratório
 - Sendo um técnico do laboratório eu desejo:
    - Cadastrar um novo laboratório no sistema
    - Cadastrar uma nova sala de um laboratório
    - Cadastrar um novo equipamento
    - Definir horários de disponibilidade dos equipamentos
    - Visualizar os equipamentos que estão agendados e que estão livres
    - Visualisar as listas de interesse em reservar equipamentos já reservados(lista de espera)
    
