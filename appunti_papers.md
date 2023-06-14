# Greedy Maximization of Submodular Functions

## 1.1 Preliminaries

L'eq 1.1 significa informalmente che gode della seguente proprietà: 

> The difference in the incremental value of the function that a single element makes when added to an input set decreases as the size of the input set increases

In altre parole, aggiungere un elemento ad un set di cardinalità $k$ ha un impatto maggiore che aggiungerlo ad un set di cardinalità $k+1$, è la legge dei rendimenti decrescenti (diminishing returns), citando Garetto "se do dieci euro ad un barbone gli ho migliorato la giornata, se li do' a Jeff Bezos mi sputa in faccia". (si sul serio l'ha detto)

Formalmente, in alternativa alla definizione 1.1 data dal paper, può anche essere scritta come:<br>
For every $X, Y \subseteq \Omega$ with $X \subseteq Y$ and every ${\displaystyle x\in \Omega \setminus Y}$ we have that $ f(X\cup \{x\})-f(X)\geq f(Y\cup \{x\})-f(Y)$.