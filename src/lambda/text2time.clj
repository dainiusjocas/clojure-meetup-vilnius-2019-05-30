(ns lambda.text2time
  (:gen-class)
  (:require [timewords.core :as t])
  (:import (java.util Date)
           (java.time Instant)))

(defn relative-time->date [rel-date]
  (try
    (Date/from (Instant/parse rel-date))
    (catch Exception e
      (Date.))))

(defn text->time [{:keys [text relative-date language] :as req}]
  (assoc req :time (t/parse text (relative-time->date relative-date) language)))
