(ns tamagotchi-web.db
  (:require [tamagotchi.core :as tamagotchi]))

(def default-db
  (tamagotchi/create))
