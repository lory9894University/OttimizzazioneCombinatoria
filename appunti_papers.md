# Greedy Maximization of Submodular Functions

## 1.1 Preliminaries

L'eq 1.1 significa informalmente che gode della seguente proprietà: 

> The difference in the incremental value of the function that a single element makes when added to an input set decreases as the size of the input set increases

In altre parole, aggiungere un elemento ad un set di cardinalità $k$ ha un impatto maggiore che aggiungerlo ad un set di cardinalità $k+1$, è la legge dei rendimenti decrescenti (diminishing returns), citando Garetto "se do dieci euro ad un barbone gli ho migliorato la giornata, se li do' a Jeff Bezos mi sputa in faccia". (si sul serio l'ha detto)

Formalmente, in alternativa alla definizione 1.1 data dal paper, può anche essere scritta come:<br>
For every $X, Y \subseteq \Omega$ with $X \subseteq Y$ and every ${\displaystyle x\in \Omega \setminus Y}$ we have that $ f(X\cup \{x\})-f(X)\geq f(Y\cup \{x\})-f(Y)$.<br>

Che è esattamente quello che il paper dice nell'eq 1.2, ma in maniera più semplice.

## 1.2 Esempi
### Directed Cuts

Consideriamo un grafo diretto $G=(V,E)$, con $V$ insieme dei nodi e $E$ insieme degli archi. Sia $S \subseteq V$ un taglio di $G$, ovvero un insieme di nodi tale che non esiste alcun arco che va da un nodo in $S$ ad un nodo in $V \setminus S$.
Consideriamo due subset $A,B \subseteq V$

- $e$ non è ne in $A$ ne in $B$ -> $e$ non è un arco di taglio, quindi non viene contato ne in $f(A) + f(B)$ ne in $f(A \cup B) + f(A \cap B)$
- $e$ va da $A$ a $B$ o viceversa -> viene contato una volta in $f(A) + f(B)$ è solo in uno dei due insiemi. Viene invece contato una volta in $f(A \cup B)$ e potrebbe ancora essere contato una volta in $f(A \cap B)$. quindi contato una volta in LHS e una o due volte in RHS. comunque $LHS \leq RHS$
- $e$ va da $A$ o $B$ ad un altro insieme (ne $A$ ne $B$). Viene contato una volta in $f(A) + f(B)$ e una volta in $f(A \cup B)$, potrebbe anche venire contato una volta in $f(A \cap B)$, se il nodo da cui parte fa parte sia di $A$ che di $B$. In ogni caso $LHS \leq RHS$

## 2 Greedy Algorithm
### 2.1 L'algoritmo
Presupponiamo la nostra submodular function monotona (come in KP dove mettiamo gli oggetti in ordine di valore/peso _attenzione però, la funzione obbiettivo di KP non è submodular, non ha diminishing returns_). Poi l'articolo si fa uno sviaggio sul fatto che dobbiamo aggiungere dei constraint (tipo il peso max dello zaino) altrimenti la soluzione è ovvia (prendi tutto).
L'algoritmo greedy è molto semplice, partiamo da un set vuoto e ad ogni passo aggiungiamo l'elemento che massimizza il guadagno marginale, ovvero il guadagno che otterremmo aggiungendo quell'elemento al set. (sezione 2.1). Il solito algoritmo greedy che cerca sempre di massimizzare.
L'algoritmo è dimostrabile essere $(1 − 1/e)$-approx della soluzione ottima. É anche dimostrabile che questa soglia ($(1-1/e)$) è la soglia più stringente possibile, ultimo paragrafo della sezione 2.1.

TODO: Ho un po' le scatole piene di dimostrare cose, questa parte la leggerò poi, comunque sembra induzione.

### 2.2 L'algoritmo "lazy" (con un treshold)
L'algoritmo greedy è comunque lento, $O(nk)$. Quindi proponiamo un nuovo algormito, che chiamiamo "lazy", che è $O(n/\epsilon \log n/\epsilon)$. pur rimanendo $(1 − 1/e − \epsilon)$-approximation.
In pratica non prendiamo il valore migliore ad ogni passo, ma tutti gli elementi con valore maggiore di un certo treshold _b_. Il treshold varia (diminuisce) ad ogni iterazione.
Nota che questo algoritmo non è solo più veloce (prende più elementi nella stessa iterazione) ma permette anche di conlcudedere prima, qualora fossimo già soddisfatti del risultato. Ricordando che lavoriamo su submodules e quindi diminishing returns, gli "ultimi" elementi che aggiungiamo superata una certa soglia potrebbero non essere così importanti, quindi potrebbe essere conveniente fermarsi prima.
partiamo con $b=\max _{x \in X} f(\{x\})$, il valore dell'elemento con valore maggiore, aggiungiamo rutti gli elementi e poi decrementiamo $b$ di un fattore $(1-\epsilon)$. ci fermiamo quando... non sto capendo.... $\epsilon b/n$ 

TODO: dimostrazione, anche questa la leggerò poi.