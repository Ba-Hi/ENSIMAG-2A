import numpy as np
import matplotlib.pyplot as plt

F0 = 7
N = 16
a = 1/32
T = 2*N*a

def f(x):
    return np.exp(2*i*np.pi*F0*x)

k = np.arange(n)

a = np.zeros(n)

for n in range(N):
    a[n] = f(na)

b = np.zeros(N)
for n in range(N):
    b[n] = f(-(n+1)a) * np.exp(2*i*np.pi*(n+1)a* k/T) * np.exp(-2*i*np.pi*n*a* k/T)



A = np.fft.fft(a)
B = np.fft.fft(b)

