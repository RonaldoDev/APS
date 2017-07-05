package com.devbattle.model;

import com.devbattle.domain.Carta;
import com.devbattle.domain.Linguagem;
import com.devbattle.domain.MensagemException;
import com.devbattle.utils.Enumeradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ronal on 21/06/2017.
 */
public class Database implements Serializable{
    private  List<Linguagem> Linguagens;

    public List<Carta> retornaBaralho()
    {
        List<Carta> _baralho =  new ArrayList<>();
        _baralho.add(new Carta(1, new ArrayList<Linguagem>(){{add(retornaLinguagem(1)); add(retornaLinguagem(7));add(retornaLinguagem(6));add(retornaLinguagem(4));}}, "Delegate","Um delegate é um tipo de referência que pode ser usado para encapsular um método nomeado ou anônimo","<html>C#<br />Javascript<br />Ruby<br />Python<br /></html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(2, new ArrayList<Linguagem>(){{add(retornaLinguagem(1)); add(retornaLinguagem(3)); add(retornaLinguagem(4)); add(retornaLinguagem(5)); add(retornaLinguagem(6)); add(retornaLinguagem(7));}}, "Gerbage Collector","Coletor de lixo  é um processo usado para a automação do gerenciamento de memória","<html>C#<br />Java<br />PHP<br />Python<br />Ruby</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(4, new ArrayList<Linguagem>(){{add(retornaLinguagem(1)); add(retornaLinguagem(3)); add(retornaLinguagem(4));add(retornaLinguagem(5));add(retornaLinguagem(7));}}, "Lambda", "É uma expressão que representa uma definição de método “em-linha”.", "<html>C#<br />Java<br />Python<br />PHP<br />Javascript</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(5, new ArrayList<Linguagem>(){{add(retornaLinguagem(1)); }}, "Linq","É um conjunto de recursosque permitem a realização de consultas diretamente em base de dados","<html>C#</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(6, new ArrayList<Linguagem>(){{add(retornaLinguagem(3)); }}, "JVM","É um programa que carrega e executa os aplicativos Java, convertendo os bytecodes em código","<html>Java</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(7, new ArrayList<Linguagem>(){{add(retornaLinguagem(1)); }}, "NetCore","O .NET Core é um fork do .NET Framework. A grosso modo, é uma versão mais enxuta onde só o core foi aproveitado","<html>C#</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(3, new ArrayList<Linguagem>(){{add(retornaLinguagem(1));add(retornaLinguagem(2));add(retornaLinguagem(3));add(retornaLinguagem(4));add(retornaLinguagem(5));add(retornaLinguagem(6));  }}, "Threads","É um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo se autodividir em duas ou mais tarefas","<html>C#, Java, <br />C/C++, Python<br />PHP, Ruby<br />Javascript<br /></html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(8, new ArrayList<Linguagem>(){{add(retornaLinguagem(1));add(retornaLinguagem(3)); }}, "Tasks","Classes que permitem abstrair a funcionalidade de threading","<html>C#<br />Java</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(9, new ArrayList<Linguagem>(){{add(retornaLinguagem(3)); }}, "Android SDK","Oferece aos desenvolvedores de software móvel a chance de brincar com a nova plataforma","<html>Java</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(10, new ArrayList<Linguagem>(){{add(retornaLinguagem(6)); }}, "Gem's","“Gem” é uma biblioteca, um conjunto de arquivos de código reusáveis","<html>Ruby</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(11, new ArrayList<Linguagem>(){{add(retornaLinguagem(5)); }}, "Zend","É um framework para aplicações Web de código aberto, orientado a objetos","<html>PHP</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(12, new ArrayList<Linguagem>(){{add(retornaLinguagem(5)); }}, "Laravel","Um Framework utilizado para o desenvolvimento web, que utiliza a arquitetura MVC e tem como principal característica","<html>PHP</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(13, new ArrayList<Linguagem>(){{add(retornaLinguagem(6)); }}, "Sinatra","Linguagem de domínio específico (DSL - Domain Specific Language) para a criação rápida de aplicações web","<html>Ruby</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(14, new ArrayList<Linguagem>(){{add(retornaLinguagem(6)); }}, "Rails","Framework livre que promete aumentar velocidade e facilidade no desenvolvimento de sites orientados a banco de dados","<html>Ruby</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(15, new ArrayList<Linguagem>(){{add(retornaLinguagem(4));}}, "Pyramid","Pyramid is a lightweight web framework aimed at taking small web apps into big web apps.","<html>Python</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(16, new ArrayList<Linguagem>(){{add(retornaLinguagem(4)); }}, "Django","Framework gratuito e de código aberto para a criação de aplicações web","<html>Python</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(17, new ArrayList<Linguagem>(){{add(retornaLinguagem(4)); add(retornaLinguagem(6)); }}, "Padrão de Facto","Um projeto, programa ou linguagem cujo uso se tornou tão difundido e imitado que existem poucos concorrentes para ele","<html>Pyhton<br />Ruby</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Interpretada ));
        _baralho.add(new Carta(18, new ArrayList<Linguagem>(){{add(retornaLinguagem(2)); }}, "GCC","É um conjunto de compiladores de linguagens de programação produzido pelo projecto GNU","<html>C/C++</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(19, new ArrayList<Linguagem>(){{add(retornaLinguagem(2)); }}, "QT","Toolkit de desenvolvimento de softwares com interface gráfica para o KDE","<html>C/C++</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(20, new ArrayList<Linguagem>(){{add(retornaLinguagem(7));add(retornaLinguagem(4));add(retornaLinguagem(6));add(retornaLinguagem(5)); }}, "Tipagem Dinâmica","Uma característica de determinadas linguagens de programação, que não exigem declarações de tipos de dados","<html>Js<br />Python<br />Ruby<br />PHP</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(21, new ArrayList<Linguagem>(){{add(retornaLinguagem(2)); }}, "Tipagem Fraca","Uma característica de determinadas linguagens de programação, não que exigem declarações de tipos de dados","<html>C/C++</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(22, new ArrayList<Linguagem>(){{add(retornaLinguagem(1));add(retornaLinguagem(2));add(retornaLinguagem(3)); }}, "Tipagem Fote","Uma característica de determinadas linguagens de programação, que exigem declarações de tipos de dados","<html>Java<br />C#<br />C/C++</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.Compilada ));
        _baralho.add(new Carta(23, new ArrayList<Linguagem>(){{add(retornaLinguagem(7)); }}, "AngularJS","Framework de código livre desenvolvida pro programadores do google","<html>Javascript</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(24, new ArrayList<Linguagem>(){{add(retornaLinguagem(7)); }}, "React","Framework desenvolvida pro programadores do facebook","<html>Javascript</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.MultiParadigma ));
        _baralho.add(new Carta(25, new ArrayList<Linguagem>(){{add(retornaLinguagem(11)); }}, "DDL","É um conjunto de comandos usados para a definição das estruturas de dados","<html>Relacional</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(26, new ArrayList<Linguagem>(){{add(retornaLinguagem(11)); }}, "DML","É um vocabulário usado para recuperar e trabalhar com dados","<html>Relacional</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(27, new ArrayList<Linguagem>(){{add(retornaLinguagem(13)); }}, "Orientado a Grafos","Em um banco de dados de grafos, relacionamentos são mais naturais com entidades chamadas de vértices ou nodes","<html>GrapdDB</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(28, new ArrayList<Linguagem>(){{add(retornaLinguagem(12)); }}, "Orientado a Documentos","Bancos de dados orientados a documentos: os documentos dos bancos dessa categoria, são coleções de atributos e valores","<html>MongoDB</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(29, new ArrayList<Linguagem>(){{add(retornaLinguagem(15)); }}, "Sprint's","É uma metodologia ágil para gestão e planejamento de projetos de software","<html>SCRUM</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(30, new ArrayList<Linguagem>(){{add(retornaLinguagem(18)); }}, "Modelos Prescritivos","Os modelos prescritivos de processo surgiram para trazer certa estrutura inicial aos processos. ","<html>Incremental</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(33, new ArrayList<Linguagem>(){{add(retornaLinguagem(17)); }}, "Cosntrução Por Etapas"," modelo de desenvolvimento de software seqüencial no qual o desenvolvimento é visto como um fluir constante para frente  através das fases ","<html>Cascata</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(34, new ArrayList<Linguagem>(){{add(retornaLinguagem(16)); }}, "Casos de Uso","","<html>UML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(35, new ArrayList<Linguagem>(){{add(retornaLinguagem(16)); }}, "Diagrama de Sequencia","","<html>UML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(36, new ArrayList<Linguagem>(){{add(retornaLinguagem(16)); }}, "Diagrama de Classes","","<html>UML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.EngSoftware ));
        _baralho.add(new Carta(37, new ArrayList<Linguagem>(){{add(retornaLinguagem(14)); }}, "PgAdmin","IDE","<html>SQL/SGDB</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(38, new ArrayList<Linguagem>(){{add(retornaLinguagem(14)); }}, "PL","IDE","<html>SQL/SGDB</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.BancoDados ));
        _baralho.add(new Carta(53, new ArrayList<Linguagem>(){{add(retornaLinguagem(10));}}, ".class","Linguagem de Marcação","<html>CSS</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(54, new ArrayList<Linguagem>(){{add(retornaLinguagem(10)); }}, "a:hover","Linguagem de Marcação","<html>CSS+</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(56, new ArrayList<Linguagem>(){{add(retornaLinguagem(10)); }}, "webkit","Linguagem de Marcação","<html>CSS/html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(57, new ArrayList<Linguagem>(){{add(retornaLinguagem(9)); }}, "<note></note>","Linguagem de Marcação","<html>XML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(58, new ArrayList<Linguagem>(){{add(retornaLinguagem(9)); }}, "<subchild></subchild>","Linguagem de Marcação","<html>XML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(59, new ArrayList<Linguagem>(){{add(retornaLinguagem(9)); }}, "<child></child>","Linguagem de Marcação","<html>XML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(63, new ArrayList<Linguagem>(){{add(retornaLinguagem(8)); }}, "<article>","Linguagem de Marcação","<html>HTML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(64, new ArrayList<Linguagem>(){{add(retornaLinguagem(8)); }}, "<audio>","Linguagem de Marcação","<html>HTML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(65, new ArrayList<Linguagem>(){{add(retornaLinguagem(8)); }}, "<style>","Linguagem de Marcação ","<html>HTML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(66, new ArrayList<Linguagem>(){{add(retornaLinguagem(8)); }}, "<script>","Linguagem de Marcação","<html>HTML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));
        _baralho.add(new Carta(70, new ArrayList<Linguagem>(){{add(retornaLinguagem(8)); }}, "<body>","Linguagem de Marcação","<html>HTML</html>","/com/devbattle/utils/img/carta_virada.png",  Enumeradores.TipoLinguagem.LinguagemMarcacao ));



        return _baralho;
    }

    public Linguagem retornaLinguagem(int pId)
    {
        Linguagens =  new ArrayList<Linguagem>();
        Linguagens.add(new Linguagem(1, "C#", Enumeradores.TipoLinguagem.Compilada, true));
        Linguagens.add(new Linguagem(2, "C/C++", Enumeradores.TipoLinguagem.Compilada, true));
        Linguagens.add(new Linguagem(3, "Java", Enumeradores.TipoLinguagem.Compilada, true));
        Linguagens.add(new Linguagem(4, "Python", Enumeradores.TipoLinguagem.Interpretada, true));
        Linguagens.add(new Linguagem(5, "PHP", Enumeradores.TipoLinguagem.Interpretada, true));
        Linguagens.add(new Linguagem(6, "Ruby", Enumeradores.TipoLinguagem.Interpretada, true));
        Linguagens.add(new Linguagem(7, "Javascript", Enumeradores.TipoLinguagem.MultiParadigma, true));
        Linguagens.add(new Linguagem(8, "HTML", Enumeradores.TipoLinguagem.LinguagemMarcacao, false));
        Linguagens.add(new Linguagem(9, "XML", Enumeradores.TipoLinguagem.LinguagemMarcacao, false));
        Linguagens.add(new Linguagem(10, "CSS", Enumeradores.TipoLinguagem.LinguagemMarcacao, false));
        Linguagens.add(new Linguagem(11, "Modelo Relacional", Enumeradores.TipoLinguagem.BancoDados, false));
        Linguagens.add(new Linguagem(12, "MongoDB", Enumeradores.TipoLinguagem.BancoDados, false));
        Linguagens.add(new Linguagem(13, "GraphDB", Enumeradores.TipoLinguagem.BancoDados, false));
        Linguagens.add(new Linguagem(14, "SGBD/SQL", Enumeradores.TipoLinguagem.BancoDados, false));
        Linguagens.add(new Linguagem(15, "Scrum", Enumeradores.TipoLinguagem.EngSoftware, false));
        Linguagens.add(new Linguagem(16, "UML", Enumeradores.TipoLinguagem.EngSoftware, false));
        Linguagens.add(new Linguagem(17, "Modelo Cascata", Enumeradores.TipoLinguagem.EngSoftware, false));
        Linguagens.add(new Linguagem(18, "Modelo Incremental", Enumeradores.TipoLinguagem.EngSoftware, false));

        return Linguagens.stream().filter(f -> f.getIdLinguagem() == pId).findFirst().get();
    }
    public List<Linguagem> getData()
    {
        return Linguagens;
    }

    public static List<MensagemException>  getMensagens()
    {
        List<MensagemException> Msg = new ArrayList<>();
        Msg.add(new MensagemException(1, "Jogada feita com Sucesso!"));
        Msg.add(new MensagemException(2, "Jogo iniciado com Sucesso!"));
        Msg.add(new MensagemException(3, "Sua vez de Jogar!"));
        Msg.add(new MensagemException(4, "Aguardando jogada de {0}."));
        Msg.add(new MensagemException(5, "Selecione somente uma carta para continuar."));
        Msg.add(new MensagemException(6, "Selecione ao menos uma carta para continuar."));
        Msg.add(new MensagemException(7, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(10, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(11, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(12, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(13, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(15, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));
        Msg.add(new MensagemException(7, "Preencha o(s) combobox com os valores correspondentes a suas cartas."));

        return Msg;

    }



}
