(ns mies-om-weasel.core-test
  (:require-macros [cemerick.cljs.test
                    :refer [is deftest with-test run-tests testing test-var]])
  (:require [mies-om-weasel.core :as core]))

(deftest app
  (is (= 1 1)))
