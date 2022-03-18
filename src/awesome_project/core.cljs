(ns awesome-project.core
  (:require
   [shadow.react-native :refer (render-root)]
   ["react" :as r]
   ["react-native" :as rn]))

(defn hello []
  (r/createElement rn/Text (clj->js {:style {:fontSize 50}}) "Hellooo"))


;; krell
(defn ^:export -main [& args]
  (hello))


;; shadow-cljs 
(defn start
  {:dev/after-load true}
  []
  (render-root "AwesomeProject" (hello)))

(defn init []
  (start))
