N <- 10000
theta <- rnorm(N, mean = 0, sd = sqrt(32)) # simuler theta ~ N(0, 32)
y <- rnorm(N, mean = theta/4, sd = sqrt(2)) # simuler y|theta ~ N(theta/4, 2)
sim_data <- data.frame(theta = theta, y = y) 
plot(sim_data, main = "Tirage selon la loi p(y, theta)")



N <- 1000
theta <- rnorm(N, mean = 0, sd = sqrt(32)) # simuler theta ~ N(0, 32)
y <- rnorm(N, mean = theta/4, sd = sqrt(2)) # simuler y|theta ~ N(theta/4, 2)
sim_data <- data.frame(theta = theta, y = y) 
plot(y, theta, col = "grey",
     main = expression(paste("1000 tirages de p(y,theta)")))

curve(2*x, col = "blue", add = TRUE)
droite_rl <- lm(theta ~ y)
abline(droite_rl, col = "orange")


N <- 100000 
theta <- rnorm(N, mean = 0, sd = sqrt(32)) # simuler theta ~ N(0, 32)
y <- rnorm(N, mean = theta/4, sd = sqrt(2)) # simuler y|theta ~ N(theta/4, 2)
sim_data <- data.frame(theta = theta, y = y) 

theta_q7 <- theta[y<= 2.01 & y>=1.99]
hist(theta_q7)
mean(theta_q7)
sd(theta_q7)

n_iter <- 2000   # nombre total d'itérations
burn_in <- 1000  # nombre d'itérations éliminées pour "perdre la condition initiale"
theta <- numeric(n_iter)
y <- numeric(n)
theta[1] <- 0

for (t in 2:n_iter) {
  # Tirage de y_t | theta_{t-1}
  y[t] <- rnorm(1, mean = theta[t-1]/4, sd = sqrt(2))
  
  # Tirage de theta_t | y_t
  theta[t] <- rnorm(1, mean = y[t]*2, sd = sqrt(16))
}

# Supprimer les valeurs initiales (burn-in)
theta_post <- theta[(burn_in+1):n_iter]
y_post <- y[(burn_in+1):n_iter]

hist(theta_post)
hist(y_post)

mean(y_post)
mean(theta_post)