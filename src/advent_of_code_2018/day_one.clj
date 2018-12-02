(ns advent-of-code-2018.day-one)

;; problem one
(defn tweak-frequency
  [tweaks]
  (reduce + 0 tweaks))

;; problem two - this could be alot more elegant
(defn tweak-frequency-detecting-cycles
  [tweaks]
  (let [seen (atom #{})
        done (atom false)]
    (reduce (fn [acc t]
              (let [result (+ acc t)]
                (swap! seen conj acc)
                (when (contains? @seen result)
                  (reset! done true))
                result))
            0
            (take-while (fn [_] (not @done)) tweaks))))
