"use client"

import { useState, useEffect } from "react"
import { motion, AnimatePresence } from "framer-motion"
import { ArrowRight, ArrowLeft, Heart, CheckCircle2, Wind, Activity, Timer, Play, Pause, RotateCcw } from "lucide-react"
import { Button } from "@/components/ui/button"
import { cn } from "@/lib/utils"

// --- DONNÉES ET IMAGES (Intégrées ici pour faciliter la modification des images) ---

type ExerciseOption = {
  id: string
  durationLabel: string
  theme: string
  title: string
  description: string
  // ICI : On ajoute l'URL de l'image spécifique
  imageUrl: string 
  exercises: {
    title: string
    what: string
    instructions: string[]
  }[]
}

const EXERCISE_DATA: ExerciseOption[] = [
  {
    id: "1min",
    durationLabel: "1 min",
    theme: "Anti-Stress",
    title: "Urgence Calme",
    description: "Une minute pour faire redescendre la pression avant une réunion importante.",
    // Image : Ambiance Zen / Nature / Respiration
    imageUrl: "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=800&q=80",
    exercises: [
      {
        title: "La Respiration Carrée",
        what: "Reset du système nerveux",
        instructions: [
          "Inspirez par le nez sur 4 secondes.",
          "Bloquez le souffle poumons pleins (4s).",
          "Expirez par le nez (4s).",
          "Bloquez poumons vides (4s).",
        ],
      },
    ],
  },
  {
    id: "3min",
    durationLabel: "3 min",
    theme: "Nuque & Yeux",
    title: "Déverrouillage",
    description: "Soulagez les tensions cervicales dues à la fixation de l'écran.",
    // Image : Femme au bureau détendue ou focus doux
    imageUrl: "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=800&q=80",
    exercises: [
      {
        title: "Le Oui-Non-Peut-être",
        what: "Mobilité cervicale",
        instructions: [
          "Tournez la tête lentement de droite à gauche.",
          "Puis de haut en bas.",
          "Enfin, penchez l'oreille vers l'épaule sans forcer.",
        ],
      },
      {
        title: "L'Aigle Assis",
        what: "Ouverture des omoplates",
        instructions: [
          "Croisez les bras devant vous.",
          "Mains sur les épaules opposées.",
          "Levez les coudes à hauteur du menton.",
        ],
      },
    ],
  },
  {
    id: "5min",
    durationLabel: "5 min",
    theme: "Dos & Hanches",
    title: "Recharge Totale",
    description: "Compensez la position assise prolongée pour éviter le mal de dos.",
    // Image : Étirement plus global
    imageUrl: "https://images.unsplash.com/photo-1544367563-12123d8965cd?w=800&q=80",
    exercises: [
      {
        title: "Le Chiffre 4",
        what: "Ouverture des hanches",
        instructions: [
          "Cheville droite sur genou gauche.",
          "Dos droit, penchez-vous légèrement en avant.",
          "Sentez l'étirement dans la fesse.",
        ],
      },
      {
        title: "La Torsion Assise",
        what: "Détox de la colonne",
        instructions: [
          "Main droite sur genou gauche.",
          "Regardez loin derrière vous.",
          "Grandissez-vous à chaque inspiration.",
        ],
      },
    ],
  },
]

// --- COMPOSANT PRINCIPAL ---

export default function Home() {
  const [selectedExercise, setSelectedExercise] = useState<ExerciseOption | null>(null)

  return (
    <main className="min-h-screen flex flex-col relative overflow-hidden bg-slate-50 dark:bg-slate-950 text-slate-900 dark:text-slate-50 transition-colors duration-300">
      {/* Background decoration */}
      <div className="fixed inset-0 pointer-events-none z-0 opacity-40">
        <div className="absolute -top-20 -right-20 w-96 h-96 bg-blue-500/10 rounded-full blur-3xl"></div>
        <div className="absolute top-1/2 -left-20 w-72 h-72 bg-purple-500/10 rounded-full blur-3xl"></div>
        <div className="absolute bottom-0 right-1/4 w-80 h-80 bg-orange-500/10 rounded-full blur-3xl"></div>
      </div>

      <header className="relative z-10 w-full p-6 md:p-8 flex justify-between items-center max-w-6xl mx-auto">
        <div className="flex items-center gap-2">
          <div className="bg-primary/10 p-2 rounded-xl text-primary">
            <Heart className="w-6 h-6 text-indigo-600" />
          </div>
          <span className="font-semibold text-xl tracking-tight">Pause QVT</span>
        </div>
      </header>

      <div className="flex-1 relative z-10 w-full max-w-6xl mx-auto p-6 md:p-8 flex flex-col">
        <AnimatePresence mode="wait">
          {!selectedExercise ? (
            <LandingView key="landing" onSelect={setSelectedExercise} />
          ) : (
            <ExerciseView key="exercise" data={selectedExercise} onBack={() => setSelectedExercise(null)} />
          )}
        </AnimatePresence>
      </div>

      <Footer />
    </main>
  )
}

function LandingView({ onSelect }: { onSelect: (option: ExerciseOption) => void }) {
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -20 }}
      transition={{ duration: 0.5 }}
      className="flex-1 flex flex-col justify-center max-w-4xl mx-auto w-full"
    >
      <div className="space-y-6 text-center mb-12 md:mb-16">
        <div className="inline-block px-4 py-1.5 rounded-full bg-indigo-100 text-indigo-700 text-sm font-bold mb-4">
          Prévention TMS & Gestion du Stress
        </div>
        <h1 className="text-4xl md:text-6xl font-bold tracking-tight text-balance">
          Votre assistant santé au bureau.
        </h1>
        <p className="text-lg md:text-xl text-slate-500 max-w-2xl mx-auto leading-relaxed text-balance">
          La sédentarité est le mal du siècle en entreprise. Ce module s'intègre à votre journée, sans changer de tenue,
          pour une démarche durable de santé au travail.
        </p>
      </div>

      <div className="space-y-8">
        <h2 className="text-2xl font-semibold text-center mb-8">
          De combien de temps disposez-vous ?
        </h2>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          {EXERCISE_DATA.map((option, index) => (
            <motion.button
              key={option.id}
              initial={{ opacity: 0, y: 20 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: index * 0.1 + 0.3 }}
              onClick={() => onSelect(option)}
              className="group relative flex flex-col p-6 h-full bg-white border border-slate-200 rounded-2xl shadow-sm hover:shadow-xl hover:border-indigo-300 transition-all duration-300 hover:scale-[1.02] text-left"
            >
              <div
                className={cn(
                  "w-12 h-12 rounded-xl flex items-center justify-center mb-4 transition-colors",
                  option.id === "1min"
                    ? "bg-orange-100 text-orange-600"
                    : option.id === "3min"
                      ? "bg-blue-100 text-blue-600"
                      : "bg-emerald-100 text-emerald-600",
                )}
              >
                {option.id === "1min" ? (
                  <Wind className="w-6 h-6" />
                ) : option.id === "3min" ? (
                  <Activity className="w-6 h-6" />
                ) : (
                  <Timer className="w-6 h-6" />
                )}
              </div>

              <div className="space-y-2 mb-4">
                <div className="flex items-center justify-between">
                  <span className="font-bold text-2xl">{option.durationLabel}</span>
                  <ArrowRight className="w-5 h-5 opacity-0 group-hover:opacity-100 transform -translate-x-2 group-hover:translate-x-0 transition-all duration-300 text-indigo-600" />
                </div>
                <h3 className="font-medium text-slate-500">{option.theme}</h3>
              </div>

              <p className="text-sm text-slate-400 mt-auto pt-4 border-t border-dashed border-slate-100">{option.description}</p>
            </motion.button>
          ))}
        </div>
      </div>
    </motion.div>
  )
}

function ExerciseView({ data, onBack }: { data: ExerciseOption; onBack: () => void }) {
  return (
    <motion.div
      initial={{ opacity: 0, x: 20 }}
      animate={{ opacity: 1, x: 0 }}
      exit={{ opacity: 0, x: -20 }}
      className="flex flex-col h-full w-full"
    >
      <button
        onClick={onBack}
        className="flex items-center text-sm font-medium text-slate-500 hover:text-slate-900 transition-colors mb-6 group w-fit"
      >
        <div className="bg-white border border-slate-200 p-2 rounded-full mr-2 group-hover:bg-slate-100 transition-colors">
          <ArrowLeft className="w-4 h-4" />
        </div>
        Retour à l'accueil
      </button>

      <div className="grid md:grid-cols-2 gap-8 md:gap-12 items-start">
        {/* Colonne Gauche : Instructions */}
        <div className="space-y-6 order-2 md:order-1">
          <div className="space-y-2">
            <span
              className={cn(
                "inline-flex items-center px-3 py-1 rounded-full text-xs font-bold uppercase tracking-wider",
                data.id === "1min"
                  ? "bg-orange-100 text-orange-700"
                  : data.id === "3min"
                    ? "bg-blue-100 text-blue-700"
                    : "bg-emerald-100 text-emerald-700",
              )}
            >
              {data.durationLabel} • {data.theme}
            </span>
            <h2 className="text-3xl md:text-4xl font-bold text-slate-900">{data.title}</h2>
            <p className="text-lg text-slate-600">{data.description}</p>
          </div>

          <div className="space-y-6">
            {data.exercises.map((ex, i) => (
              <div key={i} className="bg-white p-6 rounded-2xl border border-slate-200 shadow-sm hover:shadow-md transition-shadow">
                <div className="flex items-start gap-4">
                  <div className="mt-1 bg-slate-100 text-slate-900 w-8 h-8 rounded-full flex items-center justify-center flex-shrink-0 font-bold text-sm">
                    {i + 1}
                  </div>
                  <div className="space-y-3">
                    <div>
                      <h3 className="font-semibold text-lg text-slate-900">{ex.title}</h3>
                      <p className="text-sm text-indigo-600 font-bold mb-2">{ex.what}</p>
                    </div>
                    <ul className="space-y-2">
                      {ex.instructions.map((step, idx) => (
                        <li key={idx} className="flex items-start gap-2 text-slate-600 text-sm leading-relaxed">
                          <CheckCircle2 className="w-4 h-4 mt-0.5 text-slate-400 flex-shrink-0" />
                          <span>{step}</span>
                        </li>
                      ))}
                    </ul>
                  </div>
                </div>
              </div>
            ))}
          </div>

          <div className="pt-4">
            <Button onClick={onBack} size="lg" className="w-full md:w-auto rounded-full bg-slate-900 text-white hover:bg-slate-800">
              Terminer la pause
            </Button>
          </div>
        </div>

        {/* Colonne Droite : Image & Timer */}
        <div className="relative aspect-[4/5] md:aspect-square w-full rounded-3xl overflow-hidden bg-slate-200 shadow-2xl sticky top-8 group order-1 md:order-2">
          {/* L'image est maintenant chargée depuis data.imageUrl */}
          <img
            src={data.imageUrl}
            alt={data.theme}
            className="object-cover w-full h-full transition-transform duration-700 group-hover:scale-105"
          />
          <div className="absolute inset-0 bg-gradient-to-t from-black/80 via-black/20 to-transparent flex flex-col justify-end p-8">
            {/* Exercise Timer Component overlaid on the image */}
            <ExerciseTimer durationId={data.id} />

            <div className="text-white mt-6">
              <p className="font-medium text-white/80 uppercase tracking-wider text-xs mb-2">Focus actuel</p>
              <p className="text-2xl font-bold">{data.theme}</p>
            </div>
          </div>
        </div>
      </div>
    </motion.div>
  )
}

// Exercise Timer component
function ExerciseTimer({ durationId }: { durationId: string }) {
  const durationMap: Record<string, number> = {
    "1min": 60,
    "3min": 180,
    "5min": 300,
  }

  const totalTime = durationMap[durationId] || 60
  const [timeLeft, setTimeLeft] = useState(totalTime)
  const [isActive, setIsActive] = useState(false)
  const [isCompleted, setIsCompleted] = useState(false)

  useEffect(() => {
    let interval: NodeJS.Timeout

    if (isActive && timeLeft > 0) {
      interval = setInterval(() => {
        setTimeLeft((time) => time - 1)
      }, 1000)
    } else if (timeLeft === 0) {
      setIsActive(false)
      setIsCompleted(true)
    }

    return () => clearInterval(interval)
  }, [isActive, timeLeft])

  const toggleTimer = () => {
    if (isCompleted) {
      setTimeLeft(totalTime)
      setIsCompleted(false)
      setIsActive(true)
    } else {
      setIsActive(!isActive)
    }
  }

  const resetTimer = () => {
    setIsActive(false)
    setIsCompleted(false)
    setTimeLeft(totalTime)
  }

  const formatTime = (seconds: number) => {
    const mins = Math.floor(seconds / 60)
    const secs = seconds % 60
    return `${mins}:${secs.toString().padStart(2, "0")}`
  }

  const progress = ((totalTime - timeLeft) / totalTime) * 100

  return (
    <div className="w-full bg-black/40 backdrop-blur-md rounded-2xl p-4 border border-white/10 shadow-lg">
      <div className="flex items-center justify-between mb-4">
        <div className="flex flex-col">
          <span className="text-xs text-white/70 font-medium uppercase tracking-wider">Minuteur</span>
          <span className="text-3xl font-mono font-bold text-white tabular-nums tracking-wider">
            {formatTime(timeLeft)}
          </span>
        </div>
        <div className="flex gap-2">
          <Button
            size="icon"
            variant="secondary"
            className="h-10 w-10 rounded-full bg-white text-black hover:bg-white/90 transition-colors border-0"
            onClick={toggleTimer}
          >
            {isCompleted ? (
              <RotateCcw className="w-4 h-4" />
            ) : isActive ? (
              <Pause className="w-4 h-4" />
            ) : (
              <Play className="w-4 h-4 ml-0.5" />
            )}
          </Button>
          {(isActive || isCompleted || timeLeft !== totalTime) && (
            <Button
              size="icon"
              variant="ghost"
              className="h-10 w-10 rounded-full text-white hover:bg-white/20"
              onClick={resetTimer}
            >
              <RotateCcw className="w-4 h-4" />
            </Button>
          )}
        </div>
      </div>

      {/* Progress Bar */}
      <div className="h-1.5 w-full bg-white/20 rounded-full overflow-hidden">
        <motion.div
          className="h-full bg-white rounded-full"
          initial={{ width: 0 }}
          animate={{ width: `${progress}%` }}
          transition={{ duration: 0.5 }}
        />
      </div>
    </div>
  )
}

function Footer() {
  return (
    <footer className="relative z-10 w-full p-6 md:p-8 mt-12 border-t border-slate-200/50 bg-slate-50/50 backdrop-blur-sm">
      <div className="max-w-6xl mx-auto text-center md:text-left flex flex-col md:flex-row justify-between items-center gap-4 text-sm text-slate-500">
        <div className="max-w-xl space-y-2">
          <p className="font-medium text-slate-900"> Prenez soin de vous 🧘‍♂️ </p>
          <p>
            Projet CT5 • RSE & Santé au travail
          </p>
        </div>
        <div className="text-xs opacity-50">© {new Date().getFullYear()} Pause QVT</div>
      </div>
    </footer>
  )
}