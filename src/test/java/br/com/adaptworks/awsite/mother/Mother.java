package br.com.adaptworks.awsite.mother;

import org.hibernate.Session;

import br.com.adaptworks.awsite.builder.EnderecoBuilder;
import br.com.adaptworks.awsite.builder.EventoBuilder;
import br.com.adaptworks.awsite.builder.InstrutorBuilder;
import br.com.adaptworks.awsite.builder.OpcaoBuilder;
import br.com.adaptworks.awsite.builder.QuestaoBuilder;
import br.com.adaptworks.awsite.builder.TreinamentoBuilder;
import br.com.adaptworks.awsite.builder.TurmaBuilder;
import br.com.adaptworks.awsite.builder.UsuarioBuilder;

public class Mother {

	private final SessionHandler handler;

	public Mother(final SessionHandler handler) {
		this.handler = handler;
	}

	public void dispose() {
		handler.dispose();
	}

	public Session session() {
		return handler.session();
	}

	public UsuarioBuilder novoUsuario() {
		return new UsuarioBuilder(handler);
	}

	public TreinamentoBuilder novoTreinamento() {
		return new TreinamentoBuilder(handler);
	}

	public TurmaBuilder novaTurma() {
		return new TurmaBuilder(handler);
	}

	public InstrutorBuilder novoInstrutor() {
		return new InstrutorBuilder(handler);
	}

	public EnderecoBuilder novoEndereco() {
		return new EnderecoBuilder(handler);
	}

	public EventoBuilder novoEvento() {
		return new EventoBuilder(handler);
	}

	public QuestaoBuilder novaQuestao() {
		return new QuestaoBuilder(handler);
	}

	public OpcaoBuilder novaOpcao() {
		return new OpcaoBuilder(handler);
	}
}
