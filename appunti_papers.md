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