import numpy as np
import matplotlib.pyplot as plt

F0 = 7
N = 16
a = 1/32
T = 2*N*a

def f(x):
    return np.exp(2*np.pi*F0*x*1j)

n = np.arange(N)
k = 0
an = np.zeros(N)

for n in range(N):
    an[n] = f(n*a)

b = np.zeros(N)
for n in range(N):
    b[n] = f(-1 * ( n + 1 ) *a) * np.exp(2*np.pi*(n+1) * a* k/T * 1j) * np.exp(-2*np.pi*n*a* k/T*1j)



A = np.fft.fft(an)
B = np.fft.fft(b)

result = a * (A + B)

plt.stem(np.abs(result))
plt.show()


