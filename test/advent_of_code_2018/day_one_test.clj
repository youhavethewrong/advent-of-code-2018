(ns advent-of-code-2018.day-one-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-one :refer :all]))


(deftest first-problem
  (testing "scenario one"
    (is (= 3 (tweak-frequency [1 -2 3 1]))))
  (testing "scenario two"
    (is (= 3 (tweak-frequency [1 1 1]))))
  (testing "scenario three"
    (is (= 0 (tweak-frequency [1 1 -2]))))
  (testing "scenario four"
    (is (= -6 (tweak-frequency [-1 -2 -3])))))
