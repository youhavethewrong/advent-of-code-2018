(ns advent-of-code-2018.day-three
  (:require [clojure.string :as str]))

(def test1 ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"])

(def claim-re #"#(\d+) @ (\d+)\,(\d+)\: (\d+)x(\d+)")

(defn seqify-claims
  [claims]
  (map
   (fn [claim]
     (let [matcher (re-matcher claim-re claim)
           _ (re-find matcher)
           g (re-groups matcher)]
       (map #(java.lang.Integer/parseInt %) (rest g))))
   claims))

(seqify-claims test1)

(defn required-size
  [sclaims]
  (reduce
   (fn [acc [id x y w t]]
     (let [sx (+ x w)
           sy (+ y t)]
       {:x (max (:x acc) sx) :y (max (:y acc) sy)}))
   {:x 0 :y 0}
   sclaims))

(defn overlapping-square-inches
  [claims]
  (let [sclaims (seqify-claims claims)
        size (required-size sclaims)
        fabric (repeat (* (inc (:x size)) (inc (:y size))) [])]
    (reduce
     (fn [bacc c]

       )
     fabric
     sclaims)
    )
  )

(overlapping-square-inches test1)
