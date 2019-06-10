public class ListaPessoa {

	private CelulaPessoa primeiro; 
	private CelulaPessoa ultimo; 

	public ListaPessoa() {
		primeiro = new CelulaPessoa();
		ultimo = primeiro;
	}

	public void inserirFinal(Pessoa c) {
		CelulaPessoa aux = new CelulaPessoa();
		
		ultimo.proximo = aux;
		aux.item = c;
		ultimo = ultimo.proximo;
	}
	
    public Pessoa retirar(long identidade) {
    	CelulaPessoa aux, anterior;

        anterior = primeiro;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getId() == identidade) {
                anterior.proximo = aux.proximo;

                if (aux == ultimo) {
                    ultimo = anterior;
                }
                
                return aux.item;
            } else {
                anterior = aux;
                aux = aux.proximo;
            }
        }
        
        return null;
    }
    
    public Pessoa retirarPrimeiro() {
    	CelulaPessoa aux, posterior;

        aux = primeiro.proximo;

        if (aux != null) {
            if (aux.proximo != null) {
            	Pessoa retirado = aux.item;
            	
            	posterior = aux.proximo;
                primeiro.proximo = posterior;
                
                return retirado;
            } else {
            	primeiro.proximo = null;
            	ultimo = primeiro;
            	
            	return aux.item;
            }
        }
        
        return null;
    }
    
    public Pessoa localizar(long identidade) {
        CelulaPessoa aux;

        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getId().longValue() == identidade) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }
        
        return null;
    }

    public Boolean listaVazia() {
        if (primeiro == ultimo) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        CelulaPessoa aux;

        aux = primeiro.proximo;

        if (aux == null) {
            System.out.println("A lista de pessoas está vazia.");
        } else {
            while (aux != null) {
                System.out.println("Nome: " + aux.item.getNome() + "\n" +
                		"Identidade: " + aux.item.getId() + "\t" +
                		"Sexo: " + aux.item.getSexo() + "\t" +
                		"Idade: " + aux.item.getIdade() + "\n" +
                		"Estado civil: " + aux.item.getCivil() + "\t" +
                		"Raça: " + aux.item.getRaca() + "\n" +
                		"Morador da Zona " + aux.item.getMoradia() + "\n");
                
                aux = aux.proximo;
            }
        }
    }
    
    public void concatenar(ListaPessoa lista) {
    	this.ultimo.proximo = lista.primeiro.proximo;
    	this.ultimo = lista.ultimo;
    }
    
    public int tamanho() {
    	if (!listaVazia()) {
    		CelulaPessoa aux = primeiro.proximo;
    		int contador = 0;
    		
    		while(aux != null) {
    			contador++;
    			aux = aux.proximo;
    		}
    		
    		return contador;
    	} else {
    		return 0;
    	}
    }
    
    public ListaPessoa copiar() {
    	ListaPessoa copia = new ListaPessoa();
    	if (!listaVazia()) {
    		CelulaPessoa aux = primeiro.proximo;
    		
    		while(aux != null) {
    			Pessoa cc = new Pessoa(
    					aux.item.getId(), 
    					aux.item.getNome(), 
    					aux.item.getSexo(), 
    					aux.item.getIdade(), 
    					aux.item.getMoradia(), 
    					aux.item.getCivil(), 
    					aux.item.getRaca());
    			
    			copia.inserirFinal(cc);
    			aux = aux.proximo;
    		}
    	}
    	return copia;
    }
}
