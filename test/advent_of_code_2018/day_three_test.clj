(ns advent-of-code-2018.day-three-test
  (:require [advent-of-code-2018.day-three :as d3]
            [clojure.string :refer [split]]
            [clojure.test :refer :all]))

(def puzzle-input (split (slurp "resources/day-three-part-one.txt") #"\n"))

(deftest first-problem
  (testing "should determine that claims 1 and 2 are overlapping"
    (is (= 4 (-> ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"]
                 d3/generate-overlapping-claims
                 d3/count-overlapping))))
  (testing "should solve first puzzle"
    (is (= 105071 (-> puzzle-input
                      d3/generate-overlapping-claims
                      d3/count-overlapping)))))

(deftest second-problem
  (testing "should determine that claim 3 doesn't overlap"
    (let [claims ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"]]
      (is (= 3 (-> claims
                d3/generate-overlapping-claims
                (d3/get-non-overlapping claims)
                first)))))
    (testing "should solve second puzzle"
    (let [claims puzzle-input]
      (is (= 222 (-> claims
                     d3/generate-overlapping-claims
                     (d3/get-non-overlapping claims)
                     first))))))
