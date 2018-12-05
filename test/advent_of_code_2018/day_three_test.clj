(ns advent-of-code-2018.day-three-test
  (:require [advent-of-code-2018.day-three :as d3]
            [clojure.test :refer :all]))

(deftest first-problem
  (testing "should determine that claims 1 and 2 are overlapping"
    (is (= 4 (d3/overlapping-square-inches ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"])))))
