import { useState, useEffect, useCallback } from 'react';
import { AxiosInstance, AxiosRequestConfig } from 'axios';

interface UseFetchResult<T> {
  data: T | null;
  error: Error | null;
  isLoading: boolean;
  refetch: () => Promise<void>;
}

/**
 * Hook genérico para realizar peticiones HTTP de forma declarativa.
 * Evita repetir estados de loading, error y data en cada componente.
 * 
 * @param apiInstance Instancia de Axios específica del microservicio
 * @param url Endpoint relativo
 * @param options Configuraciones opcionales de Axios
 * @returns { data, error, isLoading, refetch }
 */
export function useFetch<T>(
  apiInstance: AxiosInstance,
  url: string,
  options?: AxiosRequestConfig
): UseFetchResult<T> {
  const [data, setData] = useState<T | null>(null);
  const [error, setError] = useState<Error | null>(null);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  const fetchData = useCallback(async () => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await apiInstance.request<T>({
        url,
        ...options,
      });
      setData(response.data);
    } catch (err: any) {
      setError(err instanceof Error ? err : new Error(err?.message || 'Error fetching data'));
    } finally {
      setIsLoading(false);
    }
  }, [apiInstance, url, options]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  return { data, error, isLoading, refetch: fetchData };
}
