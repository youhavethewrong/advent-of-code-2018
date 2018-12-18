(ns advent-of-code-2018.day-three
  (:require [clojure.string :as str]
            [clojure.pprint :as p]))

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

(defn required-size
  [sclaims]
  (reduce
   (fn [acc [id x y w t]]
     (let [sx (+ x w)
           sy (+ y t)]
       {:x (max (:x acc) sx) :y (max (:y acc) sy)}))
   {:x 0 :y 0}
   sclaims))


(defn build-fabric
  [x y]
  (vec (reduce (fn [facc _] (conj facc (vec (repeat x [])))) [] (range y))))

(defn build-claim-coordinates
  [x y w t]
  (let [xs (range x (+ x w))
        ys (range y (+ y t))]
    (mapcat
     (fn [y]
       (map
        (fn [x]
          (vector x y))
        xs))
     ys)))

;; my god how horrible
(defn generate-overlapping-claims
  [claims]
  (let [sclaims (seqify-claims claims)
        size (required-size sclaims)
        xsize (inc (:x size))
        ysize (inc (:y size))
        fabric (build-fabric xsize ysize)]
    (reduce
     (fn [facc [id x y w t]]
       (let [coords (build-claim-coordinates x y w t)]
         (reduce
          (fn [cacc [cx cy]]
            (update-in cacc [cy cx] conj id))
          facc
          coords)))
     fabric
     sclaims)))

(defn only-overlapping
  [claimed-fabric]
  (filter
   not-empty
   (mapcat
    (fn [row]
      (filter
       (fn [cell]
         (> (count cell) 1))
       row))
    claimed-fabric)))

(defn count-overlapping
  [claimed-fabric]
  (count (only-overlapping claimed-fabric)))

(defn get-non-overlapping
  [claimed-fabric claims]
  (let [sclaims (seqify-claims claims)
        overlapping-ids (reduce conj #{} (flatten (only-overlapping claimed-fabric)))]
    (filter
     (fn [id]
       (not (contains? overlapping-ids id)))
     (map first sclaims))))
