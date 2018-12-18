(ns advent-of-code-2018.day-three-test
  (:require [advent-of-code-2018.day-three :as d3]
            [clojure.string :refer [split]]
            [clojure.test :refer :all]))

(def puzzle-input (split (slurp "resources/day-three-part-one.txt") #"\n"))

(deftest first-problem
  (testing "should determine that claims 1 and 2 are overlapping"
    (is (= 4 (-> ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"]
                 d3/overlapping-square-inches
                 d3/count-overlapping))))
  (testing "should solve first puzzle"
    (is (= 2 (-> puzzle-input
                 d3/overlapping-square-inches
                 d3/count-overlapping)))))
