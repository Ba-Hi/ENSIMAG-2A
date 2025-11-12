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
an = np.zeros(N, dtype=complex)
b = np.zeros(N, dtype=complex)

for n in range(N):
    an[n] = f(n*a)

for n in range(N):
    b[n] = f(-1 * ( n + 1 ) *a) * np.exp(2*np.pi*(n+1) * a* k/T * 1j) * np.exp(-2*np.pi*n*a* k/T*1j)



A = np.fft.fft(an)
B = np.fft.fft(b)

S = a * (A + B)


plt.stem(np.arange(N), np.abs(S))
plt.xlabel("Indice k")
plt.ylabel("|S_N(k/T)|")
plt.title("Transformée discrète approximée")
plt.show()


n = np.arange(-N, N)
x_n = np.exp(2j*np.pi*F0*n*a)

# FFT sur 2N points (correspond exactement à ta somme)
S = a * np.fft.fftshift(np.fft.fft(np.fft.ifftshift(x_n)))

# k/T
k_vals = np.arange(-N, N)
freqs = k_vals / T

plt.stem(freqs, np.abs(S))
plt.xlabel("Fréquence (k/T)")
plt.ylabel("|S_N(k/T)|")
plt.title("S_N(k/T) via DFT sur 2N points")
plt.show()

# --- Variable k ---
k_vals = np.arange(-N, N)
freqs = k_vals / T  # = k/T

# --- Calcul de Δ ---
Delta = (F0 - k_vals / N) * a

# --- Formule fermée de S_N(k/T) ---
S = a * np.exp(-2j * np.pi * Delta * N) * np.sin(2 * np.pi * N * Delta) / np.sin(np.pi * Delta)

# Correction du cas où sin(pi*Delta)=0 (éviter NaN)
S[np.isnan(S)] = a * 2 * N
plt.stem(freqs, np.abs(S))
plt.xlabel("Fréquence (k/T)")
plt.ylabel("|S_N(k/T)|")
plt.title("S_N(k/T) = a·exp(-πiΔ)·sin(2πNΔ)/sin(πΔ)")
plt.grid(True)
plt.show()

def compute_S_direct(F0, a, N, k):
    n = np.arange(-N, N)  # n = -N ... N-1
    x_n = np.exp(2j * np.pi * F0 * n * a)
    S = a * np.sum(x_n * np.exp(-2j * np.pi * n * k / (2*N)))
    return S


plt.stem(np.abs(compute_S_direct(F0, a, N, k) for k in range(-N, N)))
plt.show()


