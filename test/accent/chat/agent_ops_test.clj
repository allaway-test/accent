(ns accent.chat.agent-ops-test
  (:require [clojure.test :refer :all]
            [accent.chat :refer [->OpenAIProvider tool-time get-model switch-model]]))


(deftest agent-ops-test
  (testing "get-model returns current model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (is (= "gpt-4o" (get-model provider)))))
  
  (testing "switch-model changes the model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (switch-model provider "gpt-3.5-turbo")
      (is (= "gpt-3.5-turbo" (get-model provider))))))
