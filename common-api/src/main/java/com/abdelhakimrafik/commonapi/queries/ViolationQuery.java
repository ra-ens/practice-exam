package com.abdelhakimrafik.commonapi.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class ViolationQuery {

    private abstract static class BaseViolationQuery {

    }

    /**
     * Get all violations query with pagination
     */
    @Getter @NoArgsConstructor @AllArgsConstructor
    public static class GetAll {
        private int page;
        private int size;
    }

    /**
     * Get all violation by vehicle matriculation, with pagination
     */
    @Getter @NoArgsConstructor @AllArgsConstructor
    public static class GetByMatriculation extends GetAll {
        private String matriculation;

        public GetByMatriculation(int page, int size, String matriculation) {
            super(page, size);
            this.matriculation = matriculation;
        }
    }
}
