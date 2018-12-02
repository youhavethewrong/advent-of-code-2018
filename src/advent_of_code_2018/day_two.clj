(ns advent-of-code-2018.day-two
  (require [clojure.set :as s]))

;; problem one
(defn checksum-ids
  [ids]
  (let [id-freqs (map frequencies ids)
        twos (count (filter #(not (nil? %)) (map (fn [fs] (some #(= 2 (second %)) fs)) id-freqs)))
        threes (count (filter #(not (nil? %)) (map (fn [fs] (some #(= 3 (second %)) fs)) id-freqs)))]
    (* twos threes)))

;; problem two
(defn string-diff
  [a b]
  (map-indexed
   (fn [i item]
     (if (not= item (.charAt b i))
       [i item (.charAt b i)]
       nil))
   a))

;; this is pretty inefficient - generates all 1 character differences twice
(defn generate-matches
  [ids]
  (map
   (fn [id]
     (map
      (fn [cid]
        (let [d (string-diff id  cid)
              nn (filter #(not (nil? %)) d)
              x (count nn)]
          (when (= 1 x)
            [id cid (first (first nn))])))
      ids))
   ids))

(defn take-good-matches
  [ids]
  (filter #(not (nil? %)) (flatten (generate-matches ids))))

(defn common-letters
  [[a b index]]
  (let [left (str (.substring a 0 index) (.substring a (inc index)))
        right (str (.substring b 0 index) (.substring b (inc index)))]
    (if (= left right)
      left
      "WTF")))
