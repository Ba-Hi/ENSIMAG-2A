moins <- function(i) {
  if (i == 1){
    return (100)
  } else {
    return (i - 1)
  }
}

plus <- function(i) {
  if (i == 100){
    return (1)
  } else {
    return (i + 1)
  }
}
image(y<-as.matrix(read.table("imagetd7.txt")))
alpha=log(2);beta= 0.00000001
theta=y
for (iter in 1:100){
  for(i in 1:100)
    for(j in 1:100)
    {
      sij = theta[moins(i),moins(j)]+ theta[moins(i),plus(j)]+ theta[plus(i),moins(j)]+ theta[plus(i),plus(j)]
      pij = exp(beta*sij+alpha*y[i,j])
      p = exp(beta*sij+alpha*y[i,j])+exp(-beta*sij-alpha*y[i,j])
      theta[i,j]=sample(c(-1,+1),1, prob=c(1-pij/p, pij/p)) }
  image(theta)}

